const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const port = 3000;
const connStr = "Server=regulus.cotuca.unicamp.br;Database=SKYLOS;User Id=SKYLOS;Password=skylos;";
const sql = require("mssql");

sql.connect(connStr)
    .then(conn=> global.conn = conn)
    .catch(err => console.log("erro: " + err))

app.use(bodyParser.urlencoded({extended:true}));
app.use(bodyParser.json());

const router = express.Router();
router.get('/',(req,res) => res.json({"mensagem": "A API está ativa!"}));
app.use('/',router);

app.listen(port);
console.log('O servidor está ativo!');

function execSQL(conn,sqlQry,res)
{
    conn.request()
    .query(sqlQry)
    .then(result => console.log("Sucesso " + result))
    .catch(err => console.log("Erro: " + err))       
}


router.post('/resultados',(req,res)=>
{
    const RA = parseInt(req.body.ra);
    const Cod =  parseInt(req.body.cod);
    const Nota = parseFloat(req.body.nota);
    const Frequencia = parseFloat(req.body.frequencia);

    execSQL(global.conn,"INSERT INTO RESULTADOS(RA,COD,NOTA,FREQUENCIA) VALUES("+RA + ","+Cod+","+Nota+","+Frequencia+")",res)

})


router.delete('/matriculas',(req,res)=>
{
    
})

