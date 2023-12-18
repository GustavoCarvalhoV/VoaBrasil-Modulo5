CREATE DATABASE VoaBrasil;

USE VoaBrasil;

CREATE TABLE Passagens (
id_passagem INTEGER PRIMARY KEY AUTO_INCREMENT,
id_usuario INTEGER,
id_destino INTEGER,
preco_passagem FLOAT(10,2),
horario_passagem VARCHAR(20),
data_ida_passagem VARCHAR(20),
data_volta_passagem VARCHAR(20)
);

CREATE TABLE Destinos (
id_destino INTEGER PRIMARY KEY AUTO_INCREMENT,
cidade_destino VARCHAR(20),
estado_destino VARCHAR(20)
);

CREATE TABLE Usuarios (
id_usuario INTEGER PRIMARY KEY AUTO_INCREMENT,
nome_usuario VARCHAR(20),
sobrenome_usuario VARCHAR(20),
rg_usuario VARCHAR(20),
cpf_usuario VARCHAR(20),
contato_usuario VARCHAR(20),
email_usuario VARCHAR(30),
senha_usuario VARCHAR(20)
);

ALTER TABLE Passagens ADD FOREIGN KEY(id_usuario) REFERENCES Usuarios (id_usuario);
ALTER TABLE Passagens ADD FOREIGN KEY(id_destino) REFERENCES Destinos (id_destino);

-- Criar(Create)

insert into Usuarios (nome_usuario, sobrenome_usuario, rg_usuario, cpf_usuario, contato_usuario, email_usuario, senha_usuario) values 
('Fernando', 'Torres', '000.000.001', '000.000.000-01', '0000.0001', 'fernando@voabrasil.com', '123456'),
('Junior', 'Gomes', '000.000.002', '000.000.000-02', '0000.0002', 'junior@voabrasil.com', '12345678'),
('Julia', 'Silva', '00.000.003', '000.000.000-03', '0000.0003', 'julia@voabrasil.com', '1234');

insert into Destinos (cidade_destino, estado_destino) values 
('Natal', 'Rio Grande do Norte'),
('Recife', 'Pernambuco'),
('Paraíba', 'João Pessoa');

insert into Passagens (id_usuario, id_destino, preco_passagem, horario_passagem, data_ida_passagem, data_volta_passagem) values 
(1, 1, 800.60, '12;59:59', '10/10/2023', '20/10/2023'),
(2, 2, 500.50, '10;59:59', '12/10/2023', '25/10/2023'),
(3, 3, 700.40, '08;59:59', '14/10/2023', '28/10/2023');

-- Consultar(Read)

select * from Passagens;
select * from Destinos;
select * from Usuarios;
select * 
from Passagens P, Destinos D, Usuarios U 
where P.id_destino = D.id_destino and P.id_usuario = U.id_usuario;

-- Atualizar(Update)

UPDATE Usuarios SET nome_usuario = 'Rodrigo', sobrenome_usuario = 'Santos', rg_usuario = '000.000.010', cpf_usuario = '000.000.000-10', contato_usuario = '0000-0010', email_usuario = 'rodrigo@voabrasil.com', senha_usuario = '012345' WHERE id_usuario = 1;
UPDATE Destinos SET cidade_destino = 'Fortaleza', estado_destino = 'Ceara' Where id_destino = 1;
UPDATE Passagens SET id_usuario = 2, id_destino = 2, preco_passagem = '300.00', horario_passagem = '06;49:49', data_ida_passagem = '05/09/2023', data_volta_passagem = '01/11/2023' Where id_passagem = 1;

-- Deletar(Delete)

DELETE FROM Usuarios Where id_usuario = 1;
DELETE FROM Destinos Where id_destino = 1;
DELETE FROM Passagens Where id_passagem = 1;