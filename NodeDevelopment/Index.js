const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const port = 3000;
const connStr = "Server=regulus.cotuca.unicamp.br;Database=skylos;User Id=skylos;Password=skylos;";
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

router.post('/alunos', (req,res) =>{
    const RA =parseInt(req.body.ra);
    const Nome = req.body.nome.substring(0,40);
    execSQL("INSERT INTO ALUNOS(RA,Nome) VALUES(${RA},'${nome}')",res);
})

router.post('/matriculas',(req,res)=>{
    const RA = parseInt(req.body.ra);
    const Cod =  parseInt(req.body.cod);

})

router.post('/disciplinas',)