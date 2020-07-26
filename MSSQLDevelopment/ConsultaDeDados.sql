select * from Resultados

drop table Resultados

create table Resultados
(
RA smallint,
Cod int,
Nota float not null,
Frequencia float not null,
primary key(RA,Cod)
)

sp_help Resultados