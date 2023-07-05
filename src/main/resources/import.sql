insert into cozinha (id, nome) values (1, 'Tailandesa') ;
insert into cozinha (id, nome) values (2, 'Indiana') ;
insert into cozinha (id, nome) values (3, 'Brasileira') ;
insert into cozinha (id, nome) values (4, 'Chinesa') ;
insert into cozinha (id, nome) values (5, 'Europeia') ;

insert into estado (id, nome) values (1, 'Minas Gerais') ;
insert into estado (id, nome) values (2, 'São Paulo') ;
insert into estado (id, nome) values (3, 'Ceará') ;

insert into cidade (id, nome, estado_id) values (1, 'Uberlândia', 1) ;
insert into cidade (id, nome, estado_id) values (2, 'Belo Horizonte', 1) ;
insert into cidade (id, nome, estado_id) values (3, 'São Paulo', 2 ) ;
insert into cidade (id, nome, estado_id) values (4, 'Campinas', 2) ;
insert into cidade (id, nome, estado_id) values (5, 'Fortaleza', 3) ;

insert into restaurante (id,nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, endereco_bairro ) values (1, 'Tailandesa', 10.50, 1, utc_timestamp, utc_timestamp, 1, '72017-221', 'Chacará 25', 'Quadra', '34', 'Taguatinga');
insert into restaurante (id,nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (2, 'Thai Delivery', 9.50, 1, utc_timestamp, utc_timestamp);
insert into restaurante (id,nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (3, 'Tuk Tuk Comida Indiana', 0, 3, utc_timestamp, utc_timestamp);
insert into restaurante (id,nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (4, 'Qin_Tian', 13.80, 4, utc_timestamp, utc_timestamp);
insert into restaurante (id,nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (5, 'Croinssanterie', 0, 5, utc_timestamp, utc_timestamp);



insert into forma_pagamento (id, descricao) values (1, 'Dinheiro') ;
insert into forma_pagamento (id, descricao) values (2, 'Debito') ;
insert into forma_pagamento (id, descricao) values (3, 'Credito') ;
insert into forma_pagamento (id, descricao) values (4, 'Pix') ;

insert into permissao (id, nome, descricao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas') ;
insert into permissao (id, nome, descricao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas') ;

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3);

