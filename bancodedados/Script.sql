create database CMPCD;
use CMPCD;

ALTER DATABASE CMPCD CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER DATABASE CMPCD CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

ALTER TABLE Usuarios_Pcd CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE Usuarios_Pcd_Contato CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE Usuarios_Pcd_Social CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE Usuarios_Pcd_Deficiencia CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE Usuarios_Pcd_Medico CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE Usuarios_Pcd_Responsavel CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE Usuarios_Pcd_Backup CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE Usuarios_Pcd_Contato_Backup CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE Usuarios_Pcd_Social_Backup CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE Usuarios_Pcd_Deficiencia_Backup CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE Usuarios_Pcd_Medico_Backup CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE Usuarios_Pcd_Responsavel_Backup CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


CREATE TABLE Usuarios_Pcd (
    codigo INT AUTO_INCREMENT, -- ID único para o usuário
    nomeCompleto VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    dataNascimento DATE NOT NULL,
    nome_login VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(60) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    sexo ENUM('Masculino', 'Feminino', 'outros', 'Prefiro não informar') NOT NULL,
    estadoCivil VARCHAR(20) NOT NULL,
    PRIMARY KEY (codigo)
);

CREATE TABLE Usuarios_Pcd_Contato (
    codigo_usuario INT NOT NULL, -- Chave estrangeira para Usuarios_Pcd
    telefone VARCHAR(15),
    endereco VARCHAR(100) NOT NULL,
    FOREIGN KEY (codigo_usuario) REFERENCES Usuarios_Pcd(codigo) ON DELETE CASCADE
);

CREATE TABLE Usuarios_Pcd_Social (
    codigo_usuario INT NOT NULL, -- Chave estrangeira para Usuarios_Pcd
    ocupacao VARCHAR(50) NOT NULL,
    nivelEscolaridade VARCHAR(50) NOT NULL,
    rendaFamiliarPcapita VARCHAR(100) NOT NULL,
    programaAssistenciaSocial VARCHAR(100) NOT NULL,
    FOREIGN KEY (codigo_usuario) REFERENCES Usuarios_Pcd(codigo) ON DELETE CASCADE
);

CREATE TABLE Usuarios_Pcd_Deficiencia (
    codigo_usuario INT NOT NULL, -- Chave estrangeira para Usuarios_Pcd
    tipoDeficiencia VARCHAR(50) NOT NULL,
    necessidadeAcompanhante BOOLEAN NOT NULL,
    necessidadeEquipamento BOOLEAN NOT NULL,
    explicacao_necessidade_equipamento VARCHAR(255),
    necessidadeAdaptacao BOOLEAN NOT NULL,
    explicacao_necessidade_adaptacao VARCHAR(255),
    necessidadeAdaptacaoLocalAtendimento BOOLEAN NOT NULL,
    explicacao_necessidade_adaptacao_local_atendimento VARCHAR(255),
    necessidadeEducacional BOOLEAN NOT NULL,
    explicacao_necessidade_Educacional VARCHAR(60),
    FOREIGN KEY (codigo_usuario) REFERENCES Usuarios_Pcd(codigo) ON DELETE CASCADE
);

CREATE TABLE Usuarios_Pcd_Medico (
    codigo_usuario INT NOT NULL, -- Chave estrangeira para Usuarios_Pcd
    historicoMedicoRelevante VARCHAR(350),
    usoMedicacao BOOLEAN NOT NULL,
    explicacao_uso_medicacao VARCHAR(255),
    atendimentoEspecialista BOOLEAN NOT NULL,
    explicacao_atendimento_especialista VARCHAR(255),
    participacaoCentroApoio BOOLEAN NOT NULL,
    explicacao_participacao_centro_apoio VARCHAR(255),
    FOREIGN KEY (codigo_usuario) REFERENCES Usuarios_Pcd(codigo) ON DELETE CASCADE
);

CREATE TABLE Usuarios_Pcd_Responsavel (
    id INT NOT NULL AUTO_INCREMENT, -- ID único para o registro do responsável
    codigo_usuario INT NOT NULL, -- Chave estrangeira para Usuarios_Pcd
    nomeCompleto VARCHAR(100), -- Nome completo do responsável (opcional)
    telefone VARCHAR(11), -- Telefone do responsável (opcional)
    email VARCHAR(255), -- Email do responsável (opcional)
    endereco VARCHAR(100), -- Endereço do responsável (opcional)
    PRIMARY KEY (id),
    FOREIGN KEY (codigo_usuario) REFERENCES Usuarios_Pcd(codigo) ON DELETE CASCADE
);

-- Tabela de Backup para Usuarios_Pcd
CREATE TABLE Usuarios_Pcd_Backup (
    codigo INT AUTO_INCREMENT, -- ID único para o usuário
    nomeCompleto VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    dataNascimento DATE NOT NULL,
    nome_login VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(60) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    sexo ENUM('Masculino', 'Feminino', 'outros', 'Prefiro não informar') NOT NULL,
    estadoCivil VARCHAR(20) NOT NULL,
    PRIMARY KEY (codigo)
);



CREATE TABLE Usuarios_Pcd_Contato_Backup (
    codigo_usuario INT NOT NULL, 
    telefone VARCHAR(11) NOT NULL,
    endereco VARCHAR(100) NOT NULL,
    data_exclusao TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    PRIMARY KEY (codigo_usuario)
);

CREATE TABLE Usuarios_Pcd_Social_Backup (
    codigo_usuario INT NOT NULL, 
    ocupacao VARCHAR(50) NOT NULL,
    nivelEscolaridade VARCHAR(50) NOT NULL,
    rendaFamiliarPcapita VARCHAR(100) NOT NULL,
    programaAssistenciaSocial VARCHAR(100) NOT NULL,
    data_exclusao TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    PRIMARY KEY (codigo_usuario)
);

CREATE TABLE Usuarios_Pcd_Deficiencia_Backup (
    codigo_usuario INT NOT NULL, 
    tipoDeficiencia VARCHAR(50) NOT NULL,
    necessidadeAcompanhante BOOLEAN NOT NULL,
    necessidadeEquipamento BOOLEAN NOT NULL,
    explicacao_necessidade_equipamento VARCHAR(255),
    necessidadeAdaptacao BOOLEAN NOT NULL,
    explicacao_necessidade_adaptacao VARCHAR(255),
    necessidadeAdaptacaoLocalAtendimento BOOLEAN NOT NULL,
    explicacao_necessidade_adaptacao_local_atendimento VARCHAR(255),
    necessidadeEducacional BOOLEAN NOT NULL,
    explicacao_necessidade_Educacional VARCHAR(60),
    data_exclusao TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    PRIMARY KEY (codigo_usuario)
);


CREATE TABLE Usuarios_Pcd_Medico_Backup (
    codigo_usuario INT NOT NULL, 
    historicoMedicoRelevante VARCHAR(350),
    usoMedicacao BOOLEAN NOT NULL,
    explicacao_uso_medicacao VARCHAR(255),
    atendimentoEspecialista BOOLEAN NOT NULL,
    explicacao_atendimento_especialista VARCHAR(255),
    participacaoCentroApoio BOOLEAN NOT NULL,
    explicacao_participacao_centro_apoio VARCHAR(255),
    data_exclusao TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    PRIMARY KEY (codigo_usuario)
);

CREATE TABLE Usuarios_Pcd_Responsavel_Backup (
    id INT NOT NULL AUTO_INCREMENT, 
    codigo_usuario INT NOT NULL, 
    nomeCompleto VARCHAR(100), 
    telefone VARCHAR(11), 
    email VARCHAR(255), 
    endereco VARCHAR(100),
    data_exclusao TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    PRIMARY KEY (id)
);

DELIMITER //
CREATE TRIGGER before_delete_usuarios_pcd
BEFORE DELETE ON Usuarios_Pcd
FOR EACH ROW
BEGIN
    INSERT INTO Usuarios_Pcd_Backup (codigo, nomeCompleto, cpf, dataNascimento, sexo, estadoCivil, nome_login, senha, email)
    VALUES (OLD.codigo, OLD.nomeCompleto, OLD.cpf, OLD.dataNascimento, OLD.sexo, OLD.estadoCivil, OLD.nome_login, OLD.senha, OLD.email);
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER before_delete_usuarios_pcd_tables_related
BEFORE DELETE ON Usuarios_Pcd
FOR EACH ROW
BEGIN
    -- Backup de Usuarios_Pcd_Contato
    INSERT INTO Usuarios_Pcd_Contato_Backup (codigo_usuario, telefone, endereco)
    SELECT codigo_usuario, telefone, endereco
    FROM Usuarios_Pcd_Contato
    WHERE codigo_usuario = OLD.codigo;

    -- Backup de Usuarios_Pcd_Social
    INSERT INTO Usuarios_Pcd_Social_Backup (codigo_usuario, ocupacao, nivelEscolaridade, rendaFamiliarPcapita, programaAssistenciaSocial)
    SELECT codigo_usuario, ocupacao, nivelEscolaridade, rendaFamiliarPcapita, programaAssistenciaSocial
    FROM Usuarios_Pcd_Social
    WHERE codigo_usuario = OLD.codigo;

    -- Backup de Usuarios_Pcd_Deficiencia
    INSERT INTO Usuarios_Pcd_Deficiencia_Backup (codigo_usuario, tipoDeficiencia, necessidadeAcompanhante, necessidadeEquipamento, 
    explicacao_necessidade_equipamento, necessidadeAdaptacao, explicacao_necessidade_adaptacao, necessidadeAdaptacaoLocalAtendimento, 
    explicacao_necessidade_adaptacao_local_atendimento, necessidadeEducacional, explicacao_necessidade_Educacional)
    SELECT codigo_usuario, tipoDeficiencia, necessidadeAcompanhante, necessidadeEquipamento, explicacao_necessidade_equipamento, 
    necessidadeAdaptacao, explicacao_necessidade_adaptacao, necessidadeAdaptacaoLocalAtendimento, explicacao_necessidade_adaptacao_local_atendimento, necessidadeEducacional,explicacao_necessidade_Educacional
    FROM Usuarios_Pcd_Deficiencia
    WHERE codigo_usuario = OLD.codigo;

    -- Backup de Usuarios_Pcd_Medico
    INSERT INTO Usuarios_Pcd_Medico_Backup (codigo_usuario, historicoMedicoRelevante, usoMedicacao, explicacao_uso_medicacao,
    atendimentoEspecialista, explicacao_atendimento_especialista, participacaoCentroApoio, explicacao_participacao_centro_apoio)
    SELECT codigo_usuario, historicoMedicoRelevante, usoMedicacao, explicacao_uso_medicacao, atendimentoEspecialista, explicacao_atendimento_especialista, 
    participacaoCentroApoio, explicacao_participacao_centro_apoio
    FROM Usuarios_Pcd_Medico
    WHERE codigo_usuario = OLD.codigo;

    -- Backup de Usuarios_Pcd_Responsavel
    INSERT INTO Usuarios_Pcd_Responsavel_Backup (codigo_usuario, nomeCompleto, telefone, email, endereco)
    SELECT codigo_usuario, nomeCompleto, telefone, email, endereco
    FROM Usuarios_Pcd_Responsavel
    WHERE codigo_usuario = OLD.codigo;
END;
//
DELIMITER ;


CREATE INDEX idx_nome_login ON Usuarios_Pcd (nome_login);
CREATE INDEX idx_nome_email ON Usuarios_Pcd (email);

DELIMITER //

CREATE FUNCTION verificar_nome_login(nome_login_input VARCHAR(255)) 
RETURNS BOOLEAN DETERMINISTIC
BEGIN
    DECLARE nome_existente INT DEFAULT 0;

    -- Consulta para verificar se o nome de login já está em uso
    SELECT COUNT(*) INTO nome_existente
    FROM Usuarios_Pcd
    WHERE nome_login = nome_login_input;

    -- Retorna 1 (TRUE) se o nome de login já estiver em uso, caso contrário, retorna 0 (FALSE)
    IF nome_existente > 0 THEN
        RETURN TRUE;  -- Retorna 1 para TRUE
    ELSE
        RETURN FALSE;  -- Retorna 0 para FALSE
    END IF;
END//

DELIMITER ;

DELIMITER //

CREATE FUNCTION verificar_email(email_input VARCHAR(255)) 
RETURNS BOOLEAN DETERMINISTIC
BEGIN
    DECLARE email_existente INT DEFAULT 0;

    -- Consulta para verificar se o nome de login já está em uso
    SELECT COUNT(*) INTO email_existente
    FROM Usuarios_Pcd
    WHERE email = email_input;

    -- Retorna 1 (TRUE) se o nome de login já estiver em uso, caso contrário, retorna 0 (FALSE)
    IF email_existente > 0 THEN
        RETURN TRUE;  -- Retorna 1 para TRUE
    ELSE
        RETURN FALSE;  -- Retorna 0 para FALSE
    END IF;
END//

DELIMITER ;

-- Inserir dados na tabela Usuarios_Pcd
INSERT INTO Usuarios_Pcd (nomeCompleto, cpf, dataNascimento, sexo, estadoCivil, nome_login, senha, email)
VALUES 
('João Silva', '12345678901', '1990-01-01', 'Masculino', 'Solteiro', 'joaosilva', 'senha123', 'joao@gmail.com');

-- Obter o ID gerado para o usuário
SELECT codigo FROM Usuarios_Pcd WHERE cpf = '12345678901';

-- Supondo que o código gerado foi 1, usar o código para inserir dados nas tabelas relacionadas
INSERT INTO Usuarios_Pcd_Contato (codigo_usuario, telefone, endereco)
VALUES (1, '11999999999', 'Rua Exemplo, 123');

INSERT INTO Usuarios_Pcd_Social (codigo_usuario, ocupacao, nivelEscolaridade, rendaFamiliarPcapita, programaAssistenciaSocial)
VALUES (1, 'Estudante', 'Ensino Médio', 500.00, 'Bolsa Família');

INSERT INTO Usuarios_Pcd_Deficiencia (codigo_usuario, tipoDeficiencia, necessidadeAcompanhante, necessidadeEquipamento, 
    explicacao_necessidade_equipamento, necessidadeAdaptacao, explicacao_necessidade_adaptacao, necessidadeAdaptacaoLocalAtendimento, 
    explicacao_necessidade_adaptacao_local_atendimento, necessidadeEducacional, explicacao_necessidade_Educacional)
VALUES 
(1, 'Auditiva', TRUE, TRUE, 'Aparelho auditivo', TRUE, 'Rampas de acesso', TRUE, 'Ambiente silencioso', TRUE, 'Suporte pedagógico');

INSERT INTO Usuarios_Pcd_Medico (codigo_usuario, historicoMedicoRelevante, usoMedicacao, explicacao_uso_medicacao, 
    atendimentoEspecialista, explicacao_atendimento_especialista, participacaoCentroApoio, explicacao_participacao_centro_apoio)
VALUES 
(1, 'Surdez desde os 5 anos', TRUE, 'Aparelho auditivo', TRUE, 'Fonoaudiólogo', FALSE, NULL);

INSERT INTO Usuarios_Pcd_Responsavel (codigo_usuario, nomeCompleto, telefone, email, endereco)
VALUES (1, 'Maria Silva', '11988888888', 'maria@gmail.com', 'Rua Exemplo, 123');

DELETE FROM Usuarios_Pcd WHERE codigo = 1;

use CMPCD;
SELECT * FROM Usuarios_Pcd;
SELECT * FROM Usuarios_Pcd_Contato;
SELECT * FROM Usuarios_Pcd_Social;
SELECT * FROM Usuarios_Pcd_Deficiencia;
SELECT * FROM Usuarios_Pcd_Medico;
SELECT * FROM Usuarios_Pcd_Responsavel;

SELECT * FROM Usuarios_Pcd_Backup;
SELECT * FROM Usuarios_Pcd_Contato_Backup;
SELECT * FROM Usuarios_Pcd_Social_Backup;
SELECT * FROM Usuarios_Pcd_Deficiencia_Backup;
SELECT * FROM Usuarios_Pcd_Medico_Backup;
SELECT * FROM Usuarios_Pcd_Responsavel_Backup;

DELETE FROM Usuarios_User WHERE codigo = 1;

