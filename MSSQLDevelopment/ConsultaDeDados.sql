/* Tabela Alunos */

CREATE TABLE Alunos (			
RA SMALLINT PRIMARY KEY,		
Nome VARCHAR(40) NOT NULL)

select * from Alunos
insert into Alunos values (19171,'Gabriel')
insert into Alunos values (19199,'Vicente')
insert into Alunos values (19200,'Vitor')
sp_help Alunos

/* Tabela Resultados */

select * from Resultados
CREATE TABLE Resultados (
RA SMALLINT,					
Cod INT,						
Nota FLOAT NOT NULL,
Frequencia FLOAT NOT NULL,
PRIMARY KEY (RA,Cod),
FOREIGN KEY (RA)
REFERENCES Alunos(RA),
FOREIGN KEY (Cod)
REFERENCES Disciplinas(Cod)
)
drop table Resultados
sp_help Resultados

delete from Resultados where RA = 

/* Tabela Matriculas */

select * from Matriculas
insert into Matriculas values (19171, 1)
insert into Matriculas values (19199, 2)
insert into Matriculas values (19200, 3)
drop table Matriculas
CREATE TABLE Matriculas (		
RA SMALLINT,					
Cod INT,						
PRIMARY KEY (RA,Cod),			
FOREIGN KEY (RA)				
REFERENCES Alunos(RA),		
FOREIGN KEY (Cod)				
REFERENCES Disciplinas(Cod))

/* Tabela Disciplinas */

CREATE TABLE Disciplinas (
Cod INT PRIMARY KEY,
Nome VARCHAR(40) NOT NULL)


select * from Disciplinas
insert into Disciplinas values (1, 'Matemática')
insert into Disciplinas values (2, 'Português')
insert into Disciplinas values (3, 'Artes')





