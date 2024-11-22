<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <title>Página de Perfil</title>
    <link rel="stylesheet" type="text/css" href="/cadastromunicipal/pagina/css/perfil.css">
    <link rel="stylesheet" type="text/css" href="/cadastromunicipal/pagina/css/perfilGlobal.css">
</head>

<body>
    <header class="green-color">
        <div class="ordem-header">
            <div class="primeiro-header">
                <a class="logo align">CMPCD</a>
            </div>
        </div>
    </header>

    <section class="align">
        <div class="section-Titulo">
            <h2>Perfil de Usuário</h2>
        </div>

        <div class="section-template align">
            <form class="formulario" action="/cadastromunicipal/controlebd?acao=atualizar-perfil" method="POST"
                autocomplete="on">

                <!-- Nome de Login -->
                <div class="ordem-formulario">
                    <label for="nomelogin">Nome de login:</label>
                    <input type="text" name="nomelogin" id="nomelogin" value="${usuario.nomelogin}" readonly>
                </div>

                <!-- E-mail -->
                <div class="ordem-formulario">
                    <label for="email">Email:</label>
                    <input type="text" name="email" id="email" value="${usuario.email}" readonly>
                </div>

                <!-- Nome Completo -->
                <div class="ordem-formulario">
                    <label for="nomecompleto">Nome Completo:</label>
                    <input type="text" name="nomecompleto" id="nomecompleto" value="${usuario.nomeCompleto}" readonly>
                </div>

                <!-- CPF -->
                <div class="ordem-formulario">
                    <label for="cpf">CPF:</label>
                    <input type="text" name="cpf" id="cpf" value="${usuario.cpf}" readonly>
                </div>

                <!-- Deficiência -->
                <div class="ordem-formulario">
                    <label for="tipoDeficiencia">Deficiência / Necessidade Especial:</label>
                    <input type="text" name="tipoDeficiencia" id="tipoDeficiencia" value="${usuario.tipoDeficiencia}"
                        readonly>
                </div>

                <!-- Grau de Deficiência -->
                <div class="ordem-formulario">
                    <label for="grauDeficiencia">Grau de Deficiência:</label>
                    <input type="text" name="grauDeficiencia" id="grauDeficiencia" value="${usuario.grauDeficiencia}"
                        readonly>
                </div>

                <!-- Data de Nascimento e Telefone -->
                <div>
                    <div class="ordem-formulario">
                        <label for="dataNascimento">Data de Nascimento:</label>
                        <label for="telefone">Telefone:</label>
                    </div>
                    <div class="ordem-formulario">
                        <input type="date" name="dataNascimento" id="dataNascimento" value="${usuario.dataNascimento}"
                            readonly>
                        <input type="tel" name="telefone" id="telefone" value="${usuario.telefone}" readonly>
                    </div>
                </div>

                <!-- Endereço -->
                <div class="ordem-formulario">
                    <label for="endereco">Endereço:</label>
                    <input type="text" name="endereco" id="endereco" value="${usuario.endereco}" readonly>
                </div>

                <!-- Ocupação -->
                <div class="ordem-formulario">
                    <label for="ocupacao">Ocupação:</label>
                    <input type="text" name="ocupacao" id="ocupacao" value="${usuario.ocupacao}" readonly>
                </div>

                <!-- Nível de Escolaridade -->
                <div class="ordem-formulario">
                    <label for="nivelEscolaridade">Nível de escolaridade:</label>
                    <input type="text" name="nivelEscolaridade" id="nivelEscolaridade"
                        value="${usuario.nivelEscolaridade}" readonly>
                </div>

                <!-- Gênero -->
                <div class="ordem-formulario">
                    <label for="genero">Gênero:</label>
                    <input type="text" name="genero" id="genero" value="${usuario.genero}" readonly>
                </div>

                <!-- Estado Civil -->
                <div class="ordem-formulario">
                    <label for="estadoCivil">Estado Civil:</label>
                    <input type="text" name="estadoCivil" id="estadoCivil" value="${usuario.estadocivil}" readonly>
                </div>

                <!-- Renda Familiar -->
                <div class="ordem-formulario">
                    <label for="rendaFamiliarPCapita">Renda Familiar per Capita:</label>
                    <input type="text" name="rendaFamiliarPCapita" id="rendaFamiliarPCapita"
                        value="${usuario.rendaFamiliarPCapita}" readonly>
                </div>

                <!-- Necessidades Específicas -->
                <div class="ordem-formulario">
                    <label for="necessidadeAcompanhante">Necessita de acompanhante/responsável:</label>
                    <input type="text" name="necessidadeAcompanhante" id="necessidadeAcompanhante"
                        value="${usuario.necessidadeAcompanhante ? 'Sim' : 'Não'}" readonly>
                </div>

                <div class="ordem-formulario">
                    <label for="necessidadeEquipamento">Necessita de equipamento:</label>
                    <input type="text" name="necessidadeEquipamento" id="necessidadeEquipamento"
                        value="${usuario.necessidadeEquipamento ? 'Sim' : 'Não'}" readonly>
                </div>

                <div class="ordem-formulario">
                    <label for="necessidadeTransporteAdaptado">Necessita de transporte adaptado:</label>
                    <input type="text" name="necessidadeTransporteAdaptado" id="necessidadeTransporteAdaptado"
                        value="${usuario.necessidadeTransporteAdaptado ? 'Sim' : 'Não'}" readonly>
                </div>

                <div class="ordem-formulario">
                    <label for="necessidadeAdaptacaoLocalAtendimento">Necessita de adaptação no local de
                        atendimento:</label>
                    <input type="text" name="necessidadeAdaptacaoLocalAtendimento"
                        id="necessidadeAdaptacaoLocalAtendimento"
                        value="${usuario.necessidadeAdaptacaoLocalAtendimento ? 'Sim' : 'Não'}" readonly>
                </div>

                <div class="ordem-formulario">
                    <label for="necessidadeApoioEducacional">Necessita de apoio educacional:</label>
                    <input type="text" name="necessidadeApoioEducacional" id="necessidadeApoioEducacional"
                        value="${usuario.necessidadeApoioEducacional ? 'Sim' : 'Não'}" readonly>
                </div>

                <div class="ordem-formulario">
                    <label for="usoMedicacao">Faz uso de medicação:</label>
                    <input type="text" name="usoMedicacao" id="usoMedicacao"
                        value="${usuario.usoMedicacao ? 'Sim' : 'Não'}" readonly>
                </div>

                <div class="ordem-formulario">
                    <label for="participaCentroApoio">Participa de algum centro de apoio:</label>
                    <input type="text" name="participaCentroApoio" id="participaCentroApoio"
                        value="${usuario.participaCentroApoio ? 'Sim' : 'Não'}" readonly>
                </div>

                <div class="ordem-formulario">
                    <label for="fazAtendimentoEspecialista">Faz atendimento com especialista:</label>
                    <input type="text" name="fazAtendimentoEspecialista" id="fazAtendimentoEspecialista"
                        value="${usuario.atendimentoEspecialista ? 'Sim' : 'Não'}" readonly>
                </div>

                <!-- Histórico Médico -->
                <div class="ordem-formulario">
                    <label for="historicoMedico">Histórico Médico Relevante:</label>
                    <textarea name="historicoMedico" id="historicoMedico" rows="4"
                        readonly>${usuario.historicoMedicoRelevante}</textarea>
                </div>

                <div class="align">
                    <input class="submit-btt green-color" type="submit" value="Salvar">
                </div>

            </form>
        </div>
    </section>

    <footer class="green-color align">
        <div></div>
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