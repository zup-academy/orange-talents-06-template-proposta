ALTER TABLE proposta ADD elegivel varchar(20);


update proposta
set elegivel= "NAO_ELEGIVEL"
where id>=1 and id<=2;