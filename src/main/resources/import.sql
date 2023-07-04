insert into cozinha (id, nome) values (1, 'Tailandesa') ;
insert into cozinha (id, nome) values (2, 'Indiana') ;
insert into cozinha (id, nome) values (3, 'Brasileira') ;
insert into cozinha (id, nome) values (4, 'Chinesa') ;
insert into cozinha (id, nome) values (5, 'Europeia') ;

insert into restaurante (id,nome, taxa_frete, cozinha_id) values (1, 'Thai', 10.50, 1);
insert into restaurante (id,nome, taxa_frete, cozinha_id) values (2, 'Namaste', 11.60, 2);
insert into restaurante (id,nome, taxa_frete, cozinha_id) values (3, 'Beer_House', 0, 3);
insert into restaurante (id,nome, taxa_frete, cozinha_id) values (4, 'Qin_Tian', 13.80, 4);
insert into restaurante (id,nome, taxa_frete, cozinha_id) values (5, 'Croinssanterie', 0, 5);

insert into estado (id, nome) values (1, 'Distrito Federal') ;
insert into estado (id, nome) values (2, 'São Paulo') ;
insert into estado (id, nome) values (3, 'Goias') ;

insert into cidade (id, nome, estado_id) values (1, 'Ceilandia', 1) ;
insert into cidade (id, nome, estado_id) values (2, 'Estrutural', 1) ;
insert into cidade (id, nome, estado_id) values (3, 'Aguas Lindas', 3 ) ;
insert into cidade (id, nome, estado_id) values (4, 'Valparaiso', 3) ;
insert into cidade (id, nome, estado_id) values (5, 'São Paulo', 2) ;

insert into forma_pagamento (id, descricao) values (1, 'Dinheiro') ;
insert into forma_pagamento (id, descricao) values (2, 'Debito') ;
insert into forma_pagamento (id, descricao) values (3, 'Credito') ;
insert into forma_pagamento (id, descricao) values (4, 'Pix') ;

insert into permissao (id, nome, descricao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas') ;
insert into permissao (id, nome, descricao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas') ;
