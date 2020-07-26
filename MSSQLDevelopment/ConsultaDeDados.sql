/* Tabela Alunos */

select * from Alunos
insert into Alunos values (19171,'Gabriel')
insert into Alunos values (19199,'Vicente')
insert into Alunos values (19200,'Vitor')
sp_help Alunos

/* Tabela Resultados */

select * from Resultados
create table Resultados
(
RA int,
Cod int,
Nota float not null,
Frequencia float not null,
primary key(RA,Cod)
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
create table Matriculas 
(
RA smallint,
Cod int,
primary key(RA,Cod)
)

/* Tabela Disciplinas */

select * from Disciplinas
insert into Disciplinas values (1, 'Matemática')
insert into Disciplinas values (2, 'Português')
insert into Disciplinas values (3, 'Artes')





