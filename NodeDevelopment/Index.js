const express = require("express");
const app = express();
const bodyParser = require("body-parser");
const port = 3000;
const connStr =
  "Server=regulus.cotuca.unicamp.br;Database=SKYLOS;User Id=SKYLOS;Password=skylos;";
const sql = require("mssql");

sql
  .connect(connStr)
  .then((conn) => (global.conn = conn))
  .catch((err) => console.log("erro: " + err));

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

const router = express.Router();
router.get("/", (req, res) => res.json({ mensagem: "A API está ativa!" }));
app.use("/", router);

app.listen(port);
console.log("O servidor está ativo!");

async function execSQL(sqlQry, conn) {
  try {
    return await conn.request().query(sqlQry);
  } catch (err) {
    console.log("Erro: " + err);
  }
}

router.post("/resultados", async (req, res) => {
  const RA = parseInt(req.body.ra);
  const Cod = parseInt(req.body.cod);
  const Nota = parseFloat(req.body.nota);
  const Frequencia = parseFloat(req.body.freq);

  const existsAluno = await execSQL("SELECT * FROM ALUNOS WHERE RA =" + RA, global.conn);

  const existsDisciplina = await execSQL(
    "SELECT * FROM DISCIPLINAS WHERE COD=" + Cod, global.conn
  );
  const existsMatricula = await execSQL(
    "SELECT * FROM MATRICULAS WHERE RA=" + RA + "AND COD=" + Cod, global.conn
  );

  const existsResultados = await execSQL(
    "SELECT * FROM RESULTADOS WHERE RA=" + RA + "AND COD=" + Cod, global.conn
  );

  if (existsAluno.recordset.length == 0) {
    return res.json(404);
  } else if (existsDisciplina.recordset.length == 0) {
    return res.json(404);
  } else if (existsMatricula.recordset.length == 0) {
    return res.json(404);
  } else if (existsResultados.recordset.length != 0) {
    return res.json(404);
  } else {
    execSQL(
      "INSERT INTO RESULTADOS(RA,COD,NOTA,FREQUENCIA) VALUES(" +
        RA +
        "," +
        Cod +
        "," +
        Nota +
        "," +
        Frequencia +
        ")",
      global.conn
    );

    execSQL("DELETE FROM MATRICULAS WHERE RA=" + RA + "AND COD=" + Cod, global.conn);

    return res.json(200);
  }
});
