<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <title>CMPCD</title>
    <link rel="stylesheet" type="text/css" href="/cadastromunicipal/pagina/css/cadastro.css">
    <link rel="stylesheet" type="text/css" href="/cadastromunicipal/pagina/css/cadastroGlobal.css">
</head>

<body>
    <header class="green-color">
        <div class="ordem-header">
            <div class="primeiro-header">
                <a class="logo align">Lorem ipsum dolor</a>
            </div>
        </div>

    </header>

    <section class="align">

        <div class="section-Titulo">
            <h2>Cadastre-se</h2>
            <div class="Titulo-login centerX">
                <span id="labelbtt-login">Já tem Cadastro?</span>
                <a id="btt-login">Entre aqui</a>
            </div>
        </div>

        <div class="section-template align">
            <form class="formulario" action="/cadastromunicipal/controlebd?acao=finalizar-cadastro" method="POST"
                autocomplete="on">
                <input type="hidden" name="nomelogin" value="${nome}">
                <input type="hidden" name="email" value="${email}">
                <input type="hidden" name="senha" value="${senha}">
                <!-- Nome Completo -->
                <div class="ordem-formulario">
                    <label for="nomecompleto">Nome Completo:</label>
                    <input type="text" name="nomecompleto" id="nomecompleto" placeholder="Digite seu nome completo"
                        required>
                </div>

                <!-- CPF -->
                <div class="ordem-formulario">
                    <label for="cpf">CPF:</label>
                    <input type="text" name="cpf" id="cpf" placeholder="Digite seu CPF" required>
                </div>

                <!-- Deficiência -->
                <div class="ordem-formulario">
                    <label for="tipoDeficiencia">Deficiência / Necessidade Especial:</label>
                    <select id="tipoDeficiencia" name="tipoDeficiencia">
                        <option value="" disabled selected>Selecione sua deficiência</option>
                        <option value="fisica">Física</option>
                        <option value="visual">Visual</option>
                        <option value="auditiva">Auditiva</option>
                        <option value="intelectual">Intelectual</option>
                        <option value="outro">Outro</option>
                    </select>
                </div>

                <!-- Grau de Deficiência -->
                <div class="ordem-formulario">
                    <label for="grauDeficiencia">Grau de Deficiência:</label>
                    <select id="grauDeficiencia" name="grauDeficiencia">
                        <option value="" disabled selected>Selecione o grau</option>
                        <option value="leve">Leve</option>
                        <option value="moderada">Moderada</option>
                        <option value="grave">Grave</option>
                    </select>
                </div>

                <!-- Data de Nascimento e Telefone -->
                <div>
                    <div class="ordem-formulario">
                        <label for="dataNascimento">Data de Nascimento:</label>
                        <label for="telefone">Telefone:</label>
                    </div>
                    <div class="ordem-formulario">
                        <input type="date" name="dataNascimento" id="dataNascimento" required min="1924-01-01"
                            max="2024-11-01">
                        <input type="tel" name="telefone" id="telefone" placeholder="Digite seu telefone com DDD"
                            required>
                    </div>
                </div>

                <!-- Endereço -->
                <div class="ordem-formulario">
                    <label for="endereco">Endereço:</label>
                    <input type="text" name="endereco" id="endereco" placeholder="Digite seu endereço completo"
                        required>
                </div>

                <!-- Ocupação -->
                <div class="ordem-formulario">
                    <label for="ocupacao">Ocupação:</label>
                    <select id="ocupacao" name="ocupacao">
                        <option value="" disabled selected>Selecione sua ocupação</option>
                        <option value="estudante">Estudante</option>
                        <option value="empregado">Empregado</option>
                        <option value="desempregado">Desempregado</option>
                        <option value="outro">Outro</option>
                    </select>
                </div>

                <!-- Nível de Escolaridade -->
                <div class="ordem-formulario">
                    <label for="nivelEscolaridade">Nível de escolaridade:</label>
                    <select id="nivelEscolaridade" name="nivelEscolaridade">
                        <option value="" disabled selected>Selecione seu nível de escolaridade</option>
                        <option value="fundamental_incompleto">Fundamental Incompleto</option>
                        <option value="fundamental_completo">Fundamental Completo</option>
                        <option value="medio_incompleto">Médio Incompleto</option>
                        <option value="medio_completo">Médio Completo</option>
                        <option value="superior_incompleto">Superior Incompleto</option>
                        <option value="superior_completo">Superior Completo</option>
                        <option value="pos_graduacao">Pós-Graduação</option>
                        <option value="mestrado">Mestrado</option>
                        <option value="doutorado">Doutorado</option>
                        <option value="outro">Outro</option>
                    </select>
                </div>


                <!-- Gênero -->
                <div class="ordem-formulario">
                    <label for="genero">Gênero:</label>
                    <select id="genero" name="genero">
                        <option value="" disabled selected>Selecione seu gênero</option>
                        <option value="feminino">Feminino</option>
                        <option value="masculino">Masculino</option>
                        <option value="outro">Outro</option>
                    </select>
                </div>

                <!-- Estado Civil -->
                <div class="ordem-formulario">
                    <label for="estadoCivil">Estado Civil:</label>
                    <select id="estadoCivil" name="estadoCivil">
                        <option value="" disabled selected>Selecione seu estado civil</option>
                        <option value="solteiro">Solteiro(a)</option>
                        <option value="casado">Casado(a)</option>
                        <option value="divorciado">Divorciado(a)</option>
                    </select>
                </div>

                <!-- Renda Familiar -->
                <div class="ordem-formulario">
                    <label for="rendaFamiliarPCapita">Renda Familiar per Capita:</label>
                    <select id="rendaFamiliarPCapita" name="rendaFamiliarPCapita">
                        <option value="" disabled selected>Selecione sua renda</option>
                        <option value="500">Até R$ 500</option>
                        <option value="1000">De R$ 500 a R$ 1.000</option>
                        <option value="1500">Acima de R$ 1.000</option>
                    </select>
                </div>

                <!-- Necessidades Específicas -->
                <div class="ordem-formulario">
                    <label for="necessidadeAcompanhante">Necessita de acompanhante/responsável:</label>
                    <div class="align-self">
                        <input type="radio" name="necessidadeAcompanhante" id="necessidadeAcompanhante-sim"
                            value="true"> <label for="necessidadeAcompanhante-sim">Sim</label>
                        <input type="radio" name="necessidadeAcompanhante" id="necessidadeAcompanhante-nao"
                            value="false"> <label for="necessidadeAcompanhante-nao">Não</label>
                    </div>
                </div>

                <div class="ordem-formulario">
                    <label for="necessidadeEquipamento">Necessita de equipamento:</label>
                    <div class="align-self">
                        <input type="radio" name="necessidadeEquipamento" id="necessidadeEquipamento-sim" value="true">
                        <label for="necessidadeEquipamento-sim">Sim</label>
                        <input type="radio" name="necessidadeEquipamento" id="necessidadeEquipamento-nao" value="false">
                        <label for="necessidadeEquipamento-nao">Não</label>
                    </div>
                </div>

                <div class="ordem-formulario">
                    <label for="necessidadeTransporteAdaptado">Necessita de transporte adaptado:</label>
                    <div class="align-self">
                        <input type="radio" name="necessidadeTransporteAdaptado" id="necessidadeTransporteAdaptado-sim"
                            value="true"> <label for="necessidadeTransporteAdaptado-sim">Sim</label>
                        <input type="radio" name="necessidadeTransporteAdaptado" id="necessidadeTransporteAdaptado-nao"
                            value="false"> <label for="necessidadeTransporteAdaptado-nao">Não</label>
                    </div>
                </div>

                <div class="ordem-formulario">
                    <label for="necessidadeAdaptacaoLocalAtendimento">Necessita de adaptação no local de
                        atendimento:</label>
                    <div class="align-self">
                        <input type="radio" name="necessidadeAdaptacaoLocalAtendimento"
                            id="necessidadeAdaptacaoLocalAtendimento-sim" value="true"> <label
                            for="necessidadeAdaptacaoLocalAtendimento-sim">Sim</label>
                        <input type="radio" name="necessidadeAdaptacaoLocalAtendimento"
                            id="necessidadeAdaptacaoLocalAtendimento-nao" value="false"> <label
                            for="necessidadeAdaptacaoLocalAtendimento-nao">Não</label>
                    </div>
                </div>

                <div class="ordem-formulario">
                    <label for="necessidadeApoioEducacional">Necessita de apoio educacional:</label>
                    <div class="align-self">
                        <input type="radio" name="necessidadeApoioEducacional" id="necessidadeApoioEducacional-sim"
                            value="true"> <label for="necessidadeApoioEducacional-sim">Sim</label>
                        <input type="radio" name="necessidadeApoioEducacional" id="necessidadeApoioEducacional-nao"
                            value="false"> <label for="necessidadeApoioEducacional-nao">Não</label>
                    </div>
                </div>

                <div class="ordem-formulario">
                    <label for="usoMedicacao">Faz uso de medicação:</label>
                    <div class="align-self">
                        <input type="radio" name="usoMedicacao" id="usoMedicacao-sim" value="true"> <label
                            for="usoMedicacao-sim">Sim</label>
                        <input type="radio" name="usoMedicacao" id="usoMedicacao-nao" value="false"> <label
                            for="usoMedicacao-nao">Não</label>
                    </div>
                </div>

                <div class="ordem-formulario">
                    <label for="participaCentroApoio">Participa de algum centro de apoio:</label>
                    <div class="align-self">
                        <input type="radio" name="participaCentroApoio" id="participaCentroApoio-sim" value="true">
                        <label for="participaCentroApoio-sim">Sim</label>
                        <input type="radio" name="participaCentroApoio" id="participaCentroApoio-nao" value="false">
                        <label for="participaCentroApoio-nao">Não</label>
                    </div>
                </div>

                <div class="ordem-formulario">
                    <label for="fazAtendimentoEspecialista">Faz atendimento com especialista:</label>
                    <div class="align-self">
                        <input type="radio" name="fazAtendimentoEspecialista" id="fazAtendimentoEspecialista-sim"
                            value="true"> <label for="fazAtendimentoEspecialista-sim">Sim</label>
                        <input type="radio" name="fazAtendimentoEspecialista" id="fazAtendimentoEspecialista-nao"
                            value="false"> <label for="fazAtendimentoEspecialista-nao">Não</label>
                    </div>
                </div>

                <!-- Histórico Médico -->
                <div class="ordem-formulario">
                    <label for="historicoMedico">Histórico Médico Relevante:</label>
                    <textarea name="historicoMedico" id="historicoMedico"
                        placeholder="Informe seu histórico médico, se houver" rows="4"></textarea>
                </div>

                <div class="align">
                    <input class="submit-btt green-color" type="submit" value="Cadastrar">
                </div>

            </form>

        </div>

    </section>
    <footer class="green-color align">

        <div>

        </div>
        <div>
            <ul>
                <li>Instagram</li>
                <li>Facebook</li>
                <li>Contato</li>
                <li>etc...</li>
            </ul>
        </div>


    </footer>

</body>
<script src="inicial.js"></script>

</html>