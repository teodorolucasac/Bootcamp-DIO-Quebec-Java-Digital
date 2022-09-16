SELECT numero, nome, ativo FROM banco;
SELECT banco_numero, numero, nome FROM agencia;
SELECT numero, nome email FROM cliente;
SELECT id, nome FROM tipo_transacao;
SELECT banco_numero, agencia_numero, numero, digito, cliente_numero FROM conta_corrente;
SELECT banco_numero, agencia_numero, conta_corrente_numero, conta_corrente_digito, cliente_numero, valor FROM cliente_transacoes;


-- ################################ AULA 01 ~


SELECT * FROM cliente_transacoes;

SELECT * FROM information_schema.columns WHERE table_name = 'banco';
SELECT column_name, data_type FROM information_schema.columns WHERE table_name = 'banco';

-- AVG
-- COUNT (having)
-- MAX
-- MIN
-- SUM

-- PEGA A TABELA VALOR E TIRA UMA MÉDIA DELA:
SELECT * FROM cliente_transacoes;
SELECT AVG(valor) FROM cliente_transacoes;

-- MOSTRA O TOTAL DE CLIENTES:
SELECT COUNT(numero)
FROM cliente;

-- MOSTRA TODOS OS EMAILS QUE SEJAM GMAIL:
SELECT COUNT(numero), email
FROM cliente
WHERE email ILIKE '%gmail.com'
GROUP BY email;

-- BUSCA O MAIOR VALOR DE TRANSAÇÃO:
SELECT MAX(valor)
FROM cliente_transacoes;
-- BUSCA O MENOR VALOR DE TRANSAÇÃO:
SELECT MIN(valor)
FROM cliente_transacoes;

-- MÁXIMO VALOR DE CADA TIPO DE TRANSAÇÃO:
SELECT MAX(valor), tipo_transacao_id
FROM cliente_transacoes
GROUP BY tipo_transacao_id;

SELECT column_name, data_type FROM information_schema.columns WHERE table_name = 'cliente_transacoes';
-- CONTA QUANTAS TRANSAÇÕES TIVERAM APENAS O TIPO DE TRANSAÇÃO COM MAIS DE 150:
SELECT COUNT(id), tipo_transacao_id
FROM cliente_transacoes
GROUP BY tipo_transacao_id
HAVING COUNT(id) > 150;

-- SOMA O VALOR DE TODAS AS TRANSAÇÕES:
SELECT SUM(valor)
FROM cliente_transacoes;

-- SOMA O VALOR DE TODAS AS TRANSAÇÕES POR TIPO:
SELECT SUM(valor), tipo_transacao_id
FROM cliente_transacoes
GROUP BY tipo_transacao_id;

-- SOMA O VALOR DE TODAS AS TRANSAÇÕES POR TIPO E ORDENA CRESCENTE:
SELECT SUM(valor), tipo_transacao_id
FROM cliente_transacoes
GROUP BY tipo_transacao_id
ORDER BY tipo_transacao_id ASC;

-- SOMA O VALOR DE TODAS AS TRANSAÇÕES POR TIPO E ORDENA DECRECENTE:
SELECT SUM(valor), tipo_transacao_id
FROM cliente_transacoes
GROUP BY tipo_transacao_id
ORDER BY tipo_transacao_id DESC;

-- ################################ AULA 02 ~

-- MOSTRA QUANTOS BANCOS TEM (151)
SELECT count(1) FROM banco; 
-- MOSTRA QUANTAS AGÊNCAS TEM (296)
SELECT count(1) FROM agencia; 

-- MOSTRA TODAS AS AGÊNCIAS E SEUS RESPECTIVOS BANCOS
SELECT banco.numero, banco.nome, agencia.numero, agencia.nome
FROM banco
JOIN agencia ON agencia.banco_numero = banco.numero;

-- MOSTRA TODOS OS BANCOS QUE TEM AGÊNCIA (296)
SELECT count(banco.numero)
FROM banco
JOIN agencia ON agencia.banco_numero = banco.numero;

-- MOSTRA CADA BANCO QUE TEM AGÊNCIA E QUANTAS AGÊNCIAS TEM (9 | X)
SELECT count(banco.numero)
FROM banco
JOIN agencia ON agencia.banco_numero = banco.numero
GROUP BY banco.numero;

-- CONTA QUANTOS BANCO TEM AGÊNCIAS (9)
SELECT count(distinct banco.numero)
FROM banco
JOIN agencia ON agencia.banco_numero = banco.numero;

-- MOSTRA TODOS OS BANCOS QUE TEM E QUE NÃO TEM RELACIONAMENTO COM AGENCIAS
-- 296(AGÊNCIAS) + 151(BANCOS) - 9(BANCOS QUE JÁ RELACIONA COM AGÊNCIAS) = (439)
SELECT banco.numero, banco.nome, agencia.numero, agencia.nome
FROM banco
LEFT JOIN agencia ON agencia.banco_numero = banco.numero;

-- FUNCIONOU IGUAL O LEFT JOIN PORQUE NÃO TEMOS UM BOM EXEMPLO, PRECISARIAMOS DE MAIS COLUNAS (NÃO ENTENDI DIREITO)
SELECT agencia.numero, agencia.nome, banco.numero, banco.nome
FROM agencia
RIGHT JOIN banco ON banco.numero = agencia.banco_numero;

-- MOSTRA TODAS AS AGÊNCIA SE HOUVEM VINCULO COM UM BANCO
SELECT agencia.numero, agencia.nome, banco.numero, banco.nome
FROM agencia
LEFT JOIN banco ON banco.numero = agencia.banco_numero;

-- MOSTRA TODAS AS POSSIBILIDADE ENTRE AGENCIAS E BANCOS
SELECT banco.numero, banco.nome, agencia.numero, agencia.nome
FROM banco
FULL JOIN agencia ON agencia.banco_numero = banco.numero;

-- CRIANDO TABELA PARA MOSTRAR MELHORES EXEMPLOS
CREATE TABLE IF NOT EXISTS teste_a (id serial primary key, valor varchar(10));
CREATE TABLE IF NOT EXISTS teste_b (id serial primary key, valor varchar(10));

INSERT INTO teste_a (valor) VALUES ('teste1');
INSERT INTO teste_a (valor) VALUES ('teste2');
INSERT INTO teste_a (valor) VALUES ('teste3');
INSERT INTO teste_a (valor) VALUES ('teste4');

INSERT INTO teste_b (valor) VALUES ('teste_a');
INSERT INTO teste_b (valor) VALUES ('teste_b');
INSERT INTO teste_b (valor) VALUES ('teste_c');
INSERT INTO teste_b (valor) VALUES ('teste_d');

-- CASA AS TABELAS COM TODAS AS POSSIBILIDADE ENTRE teste_a e teste_b (16 linhas)
SELECT tbla.valor, tblb.valor
FROM teste_a tbla
CROSS JOIN teste_b tblb

DROP TABLE IF EXISTS teste_a;
DROP TABLE IF EXISTS teste_b;

-- CRIOU TODAS AS CONTAS DE TODOS OS BANCOS RELACIONADA COM CADA CLIENTE
SELECT 	banco.nome,
		agencia.nome,
		conta_corrente.numero,
		conta_corrente.digito,
		cliente.nome
FROM banco
JOIN agencia 
	ON agencia.banco_numero = banco.numero
JOIN conta_corrente 
	-- ON conta_corrente.banco_numero = agencia.banco_numero
	ON conta_corrente.banco_numero = banco.numero
	AND conta_corrente.agencia_numero = agencia.numero
JOIN cliente
	ON cliente.numero = conta_corrente.cliente_numero;



-- ################################ AULA 03 ~

-- STATMENTS: SÃO FORMAS DE TRABALHAR MELHOR COM CÓDIGOS MAIORES
WITH tbl_tmp_banco AS (
	SELECT numero, nome
	FROM banco
)
SELECT numero, nome
FROM tbl_tmp_banco;
		

WITH params AS (
	SELECT 213 AS banco_numero
), tbl_tmp_banco AS(
	SELECT numero, nome
	FROM banco
	JOIN params ON params.banco_numero = banco.numero
)
SELECT numero, nome
FROM tbl_tmp_banco;

-- SUBSELECT:
SELECT banco.numero, banco.nome
FROM banco
JOIN (
	SELECT 213 AS banco_numero
) params ON params.banco_numero = banco.numero;


-- MOSTRA TODOS OS CLIENTES, TODAS AS TRANSAÇÕE E VALORES (2018 transações)
WITH clientes_e_transacoes AS (
	SELECT 	cliente.nome AS cliente_nome,
			tipo_transacao.nome AS tipo_transacao_nome,
			cliente_transacoes.valor AS tipo_transacao_valor
	FROM cliente_transacoes
	JOIN cliente ON cliente.numero = cliente_transacoes.cliente_numero
	JOIN tipo_transacao ON tipo_transacao.id = cliente_transacoes.tipo_transacao_id
)
SELECT cliente_nome, tipo_transacao_nome, tipo_transacao_valor
FROM clientes_e_transacoes;

-- SOMENTE TRANSAÇÕES FEITAS NO BANCO ITAU (217 transações)
WITH clientes_e_transacoes AS (
	SELECT 	cliente.nome AS cliente_nome,
			tipo_transacao.nome AS tipo_transacao_nome,
			cliente_transacoes.valor AS tipo_transacao_valor
	FROM cliente_transacoes
	JOIN cliente ON cliente.numero = cliente_transacoes.cliente_numero
	JOIN tipo_transacao ON tipo_transacao.id = cliente_transacoes.tipo_transacao_id
	JOIN banco ON banco.numero = cliente_transacoes.banco_numero AND banco.nome ILIKE '%Itaú%'
)
SELECT cliente_nome, tipo_transacao_nome, tipo_transacao_valor
FROM clientes_e_transacoes;