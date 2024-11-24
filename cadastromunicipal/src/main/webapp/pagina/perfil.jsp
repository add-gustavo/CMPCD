<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="UTF-8">
            <title>Perfil</title>
            <link rel="stylesheet" type="text/css" href="/cadastromunicipal/pagina/css/perfil.css">
            <link rel="stylesheet" type="text/css" href="/cadastromunicipal/pagina/css/perfilGlobal.css">
            <link rel="stylesheet"
                href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
            <!-- Adicionando Font Awesome -->
        </head>

        <body>
            <header class="green-color">
                <div class="ordem-header">
                    <div class="primeiro-header">
                        <a href="/cadastromunicipal/page?pagina=inicial" class="logo align">Lorem ipsum dolor</a>
                    </div>
                </div>
            </header>

            <section class=" align">
                <div class="section-Titulo">
                    <h2>Perfil do Usuário</h2>
                </div>
                <div class="formulario align">

                    <form class="section-template" action="/cadastromunicipal/controleuser?acao=atualizar-dadospessoais"
                        method="POST" autocomplete="on">
                        <input type="hidden" name="codigo" value="${usuarioPcd.codigo}">
                        <div class="Titulo-form">
                            <h3>Informações Pessoais</h3>
                            <i class=" fas fa-edit edit-icon"></i> <!-- Ícone de editar -->
                        </div>
                        <div class="ordem-formulario">
                            <label>Nome Completo:</label>
                            <input type="text" name="nomecompleto" id="nomecompleto" value="${usuarioPcd.nomeCompleto}"
                                readonly><br>
                        </div>
                        <div class="ordem-formulario">
                            <label>Nome Login:</label>
                            <input type="text" name="nomelogin" id="nomelogin" value="${usuarioPcd.nomeLogin}"
                                readonly><br>
                        </div>
                        <div class="ordem-formulario">
                            <label>Estado Civil:</label>
                            <label>Sexo:</label>
                        </div>
                        <div class="ordem-formulario">
                            <select id="estadoCivil" name="estadoCivil" required disabled>
                                <option name="estadoCivil" value="" disabled ${usuarioPcd.estadoCivil=="" ? "selected"
                                    : "" }>Selecione seu
                                    estado civil</option>
                                <option name="estadoCivil" value="solteiro" ${usuarioPcd.estadoCivil=='solteiro'
                                    ? "selected" : "" }>
                                    Solteiro(a)</option>
                                <option name="estadoCivil" value="casado" ${usuarioPcd.estadoCivil=='casado'
                                    ? "selected" : "" }>Casado(a)
                                </option>
                                <option name="estadoCivil" value="divorciado" ${usuarioPcd.estadoCivil=='divorciado'
                                    ? "selected" : "" }>
                                    Divorciado(a)</option>
                            </select>
                            <select id="sexo" name="sexo" required disabled>
                                <option name="sexo" value="Feminino" ${usuarioPcd.sexo=='Feminino' ? "selected" : "" }>
                                    Feminino
                                </option>
                                <option name="sexo" value="Masculino" ${usuarioPcd.sexo=='Masculino' ? "selected" : ""
                                    }>Masculino
                                </option>
                                <option name="sexo" value="Outros" ${usuarioPcd.sexo=='outros' ? "selected" : "" }>Outro
                                </option>
                                <option name="sexo" value="Prefiro não informar"
                                    ${usuarioPcd.sexo=='Prefiro não informar' ? "selected" : "" }>Prefiro não informar
                                </option>
                            </select>
                        </div>
                        <div class="ordem-formulario">
                            <label>Data de Nascimento:</label>
                            <label>CPF:</label>
                        </div>
                        <div class="ordem-formulario">
                            <input value="${usuarioPcd.dataNascimento}" type="date" name="dataNascimento"
                                id="dataNascimento" required min="1924-01-01" max="2024-11-01" readonly>
                            <input name="cpf" id="cpf" type="text" value="${usuarioPcd.cpf}" required minlength="11"
                                maxlength="11" readonly><br>
                        </div>
                    </form>


                    <!-- Contato -->
                    <form class="section-template" action="/cadastromunicipal/controleuser?acao=atualizar-dadoscontato"
                        method="POST" autocomplete="on">
                        <input type="hidden" name="codigo" value="${usuarioPcd.codigo}">
                        <div class="Titulo-form">
                            <h3>Contato</h3>
                            <i class="fas fa-edit edit-icon"></i> <!-- Ícone de editar -->
                        </div>
                        <div class="ordem-formulario">
                            <label>Endereço:</label>
                            <input type="text" name="endereco" id="endereco" value="${contato.endereco}" readonly><br>
                        </div>
                        <div class="ordem-formulario">
                            <label>Telefone:</label>
                            <input name="telefone" id="telefone" type="text" value="${contato.telefone}" minlength="11"
                                maxlength="15" readonly><br>
                        </div>
                    </form>


                    <!-- Informações Sociais -->
                    <form class="section-template" action="/cadastromunicipal/controleuser?acao=atualizar-dadossociais"
                        method="POST" autocomplete="on">
                        <input type="hidden" name="codigo" value="${usuarioPcd.codigo}">
                        <div class="Titulo-form">
                            <h3>Social</h3>
                            <i class="fas fa-edit edit-icon"></i> <!-- Ícone de editar -->
                        </div>
                        <div class="ordem-formulario">
                            <label>Ocupação:</label>
                            <select id="ocupacao" id="ocupacao" name="ocupacao" required disabled>
                                <option value="estudante" ${social.ocupacao=='estudante' ? "selected" : "" }>Estudante
                                </option>
                                <option value="empregado" ${social.ocupacao=='empregado' ? "selected" : "" }>Empregado
                                </option>
                                <option value="desempregado" ${social.ocupacao=='desempregado' ? "selected" : "" }>
                                    Desempregado</option>
                                <option value="outro" ${social.ocupacao=='outro' ? "selected" : "" }>Outro</option>
                            </select>
                        </div>
                        <div class="ordem-formulario">
                            <label>Nível de Escolaridade:</label>
                            <select id="nivelEscolaridade" id="nivelEscolaridade" name="nivelEscolaridade" required
                                disabled>
                                <option value="fundamental_incompleto"
                                    ${social.nivelEscolaridade=='fundamental_incompleto' ? "selected" : "" }>Fundamental
                                    Incompleto</option>
                                <option value="fundamental_completo" ${social.nivelEscolaridade=='fundamental_completo'
                                    ? "selected" : "" }>Fundamental Completo</option>
                                <option value="medio_incompleto" ${social.nivelEscolaridade=='medio_incompleto'
                                    ? "selected" : "" }>Médio Incompleto</option>
                                <option value="medio_completo" ${social.nivelEscolaridade=='medio_completo' ? "selected"
                                    : "" }>Médio Completo</option>
                                <option value="superior_incompleto" ${social.nivelEscolaridade=='superior_incompleto'
                                    ? "selected" : "" }>Superior Incompleto</option>
                                <option value="superior_completo" ${social.nivelEscolaridade=='superior_completo'
                                    ? "selected" : "" }>Superior Completo</option>
                                <option value="pos_graduacao" ${social.nivelEscolaridade=='pos_graduacao' ? "selected"
                                    : "" }>Pós-Graduação</option>
                                <option value="mestrado" ${social.nivelEscolaridade=='mestrado' ? "selected" : "" }>
                                    Mestrado</option>
                                <option value="doutorado" ${social.nivelEscolaridade=='doutorado' ? "selected" : "" }>
                                    Doutorado</option>
                                <option value="outro" ${social.nivelEscolaridade=='outro' ? "selected" : "" }>Outro
                                </option>
                            </select>
                        </div>
                        <div class="ordem-formulario">
                            <label>Renda Familiar per Capita:</label>
                            <select id="rendaFamiliarPCapita" id="rendaFamiliarPCapita" name="rendaFamiliarPCapita"
                                required disabled>
                                <option value="500" ${social.rendaFamiliarPcapita=='500' ? "selected" : "" }>Até R$ 500
                                </option>
                                <option value="1000" ${social.rendaFamiliarPcapita=='1000' ? "selected" : "" }>De R$ 500
                                    a R$ 1.000</option>
                                <option value="1500" ${social.rendaFamiliarPcapita=='1500' ? "selected" : "" }>Acima de
                                    R$ 1.000</option>
                            </select>
                        </div>
                        <div class="ordem-formulario">
                            <label>Programa de Assistência Social:</label>
                            <select required id="programaAssistenciaSocial" name="programaAssistenciaSocial" disabled>
                                <option value="bolsaFamilia" ${social.programaAssistenciaSocial=='bolsaFamilia'
                                    ? "selected" : "" }>Bolsa Família</option>
                                <option value="auxilioBrasil" ${social.programaAssistenciaSocial=='auxilioBrasil'
                                    ? "selected" : "" }>Auxílio Brasil</option>
                                <option value="cestaBasica" ${social.programaAssistenciaSocial=='cestaBasica'
                                    ? "selected" : "" }>Cesta Básica</option>
                                <option value="cartaoMerenda" ${social.programaAssistenciaSocial=='cartaoMerenda'
                                    ? "selected" : "" }>Cartão Merenda</option>
                                <option value="auxilioGás" ${social.programaAssistenciaSocial=='auxilioGás' ? "selected"
                                    : "" }>Auxílio Gás</option>
                                <option value="bpcLoas" ${social.programaAssistenciaSocial=='bpcLoas' ? "selected" : ""
                                    }>BPC/LOAS</option>
                                <option value="outro" ${social.programaAssistenciaSocial=='outro' ? "selected" : "" }>
                                    Outro</option>
                            </select>
                        </div>
                    </form>


                    <form class="section-template" action="/cadastromunicipal/controleuser?acao=atualizar-dadosmedicos"
                        method="POST" autocomplete="on">
                        <input type="hidden" name="codigo" value="${usuarioPcd.codigo}">
                        <div class="Titulo-form">
                            <h3>Medicação e Saúde</h3>
                            <i class="fas fa-edit edit-icon"></i> <!-- Ícone de editar -->
                        </div>

                        <div class="ordem-formulario">
                            <label>Faz uso de medicação:</label>
                            <div class="align-self">

                                <input disabled type="radio" value="true" name="usoMedicacao" id="usoMedicacao-sim"
                                    <c:if test="${medico.usoMedicacao == true}">checked</c:if>>
                                <label for="usoMedicacao-sim">Sim</label>


                                <input disabled type="radio" value="false" name="usoMedicacao" id="usoMedicacao-nao"
                                    <c:if test="${medico.usoMedicacao == false}">checked</c:if>>
                                <label for="usoMedicacao-nao">Não</label>

                            </div>
                        </div>

                        <div class="ordem-formulario">
                            <label></label>
                            <textarea name="explicacaoUsoMedicacao" id="explicacaoUsoMedicacao" rows="4"
                                placeholder="Informe o uso de Medicação"
                                readonly>${medico.explicacaoUsoMedicacao}</textarea>
                        </div>

                        <div class="ordem-formulario">
                            <label>Atendimento com Especialista:</label>
                            <div class="radio align">
                                <div class="ordem-formulario centerX">
                                    <input disabled type="radio" value="true" name="fazAtendimentoEspecialista"
                                        id="fazAtendimentoEspecialista-sim" <c:if
                                        test="${medico.atendimentoEspecialista == true}">checked</c:if>>
                                    <label for="atendimentoEspecialista-sim">Sim</label>
                                </div>
                                <div class="ordem-formulario centerX">
                                    <input disabled value="false" type="radio" name="fazAtendimentoEspecialista"
                                        id="fazAtendimentoEspecialista-nao" <c:if
                                        test="${medico.atendimentoEspecialista == false}">checked</c:if>>
                                    <label for="atendimentoEspecialista-nao">Não</label>
                                </div>
                            </div>
                        </div>

                        <div class="ordem-formulario">
                            <label></label>
                            <textarea name="explicacaoAtendimentoEspecialista" id="explicacaoAtendimentoEspecialista"
                                placeholder="Informe quais especialistas você faz atendimento" rows="4"
                                readonly>${medico.explicacaoAtendimentoEspecialista}</textarea>
                        </div>

                        <div class="ordem-formulario">
                            <label for="participaCentroApoio">Participa de algum centro de apoio:</label>
                            <div class="radio align">
                                <div class="ordem-formulario centerX">
                                    <input disabled required type="radio" value="true" name="participaCentroApoio"
                                        id="participaCentroApoio-sim" <c:if
                                        test="${medico.participacaoCentroApoio == true}">checked</c:if>>
                                    <label for="participaCentroApoio-sim">Sim</label>
                                </div>
                                <div class="ordem-formulario centerX">
                                    <input disabled required value="false" type="radio" name="participaCentroApoio"
                                        id="participaCentroApoio-nao" value="false" <c:if
                                        test="${medico.participacaoCentroApoio == false}">checked</c:if>>
                                    <label for="participaCentroApoio-nao">Não</label>
                                </div>
                            </div>
                        </div>
                        <div class="ordem-formulario">
                            <label></label>
                            <textarea readonly name="explicacaoParticipacaoCentroApoio"
                                id="explicacaoParticipacaoCentroApoio"
                                rows="4">${medico.explicacaoParticipacaoCentroApoio}</textarea>
                        </div>

                        <div class="ordem-formulario">
                            <label>Histórico Médico:</label>
                            <textarea name="historicoMedico" rows="4"
                                readonly>${medico.historicoMedicoRelevante}</textarea>
                        </div>
                    </form>

                    <!-- Aspectos da Deficiência -->
                    <form class="section-template"
                        action="/cadastromunicipal/controleuser?acao=atualizar-dadosdeficiencia" method="POST"
                        autocomplete="on">
                        <input type="hidden" name="codigo" value="${usuarioPcd.codigo}">
                        <div class="Titulo-form">
                            <h3>Aspectos da Deficiência</h3>
                            <i class="fas fa-edit edit-icon"></i> <!-- Ícone de editar -->
                        </div>

                        <div class="ordem-formulario">
                            <label>Deficiência:</label>
                            <select required disabled id="tipoDeficiencia" name="tipoDeficiencia">
                                <option value="" disabled ${deficiencia.tipoDeficiencia=="" ? "selected" : "" }>
                                    Selecione sua deficiência</option>
                                <option value="fisica" ${deficiencia.tipoDeficiencia=="fisica" ? "selected" : "" }>
                                    Física</option>
                                <option value="visual" ${deficiencia.tipoDeficiencia=="visual" ? "selected" : "" }>
                                    Visual</option>
                                <option value="auditiva" ${deficiencia.tipoDeficiencia=="auditiva" ? "selected" : "" }>
                                    Auditiva</option>
                                <option value="intelectual" ${deficiencia.tipoDeficiencia=="intelectual" ? "selected"
                                    : "" }>Intelectual</option>
                                <option value="outro" ${deficiencia.tipoDeficiencia=="outro" ? "selected" : "" }>Outro
                                </option>
                            </select>

                        </div>

                        <div class="ordem-formulario">
                            <label>Necessita de Equipamento:</label>
                            <div class="radio align">
                                <div class="ordem-formulario centerX">
                                    <input disabled type="radio" value="true" name="necessidadeEquipamento"
                                        id="necessidadeEquipamento-sim" <c:if
                                        test="${deficiencia.necessidadeEquipamento == true}">checked</c:if>>
                                    <label for="necessidadeEquipamento-sim">Sim</label>
                                </div>
                                <div class="ordem-formulario centerX">
                                    <input disabled type="radio" value="false" name="necessidadeEquipamento"
                                        id="necessidadeEquipamento-nao" <c:if
                                        test="${deficiencia.necessidadeEquipamento == false}">checked</c:if>>
                                    <label for="necessidadeEquipamento-nao">Não</label>
                                </div>
                            </div>
                        </div>

                        <div class="ordem-formulario">
                            <label></label>
                            <textarea name="explicacaoNecessidadeEquipamento" id="explicacaoNecessidadeEquipamento"
                                rows="4" readonly>${deficiencia.explicacaoNecessidadeEquipamento}</textarea>
                        </div>

                        <div class="ordem-formulario">
                            <label>Necessita de Transporte Adaptado:</label>
                            <div class="radio align">
                                <div class="ordem-formulario centerX">
                                    <input disabled type="radio" value="true" name="necessidadeTransporteAdaptado"
                                        id="necessidadeTransporteAdaptado-sim" <c:if
                                        test="${deficiencia.necessidadeAdaptacao == true}">checked</c:if>>
                                    <label for="necessidadeAdaptacao-sim">Sim</label>
                                </div>
                                <div class="ordem-formulario centerX">
                                    <input disabled type="radio" value="false" name="necessidadeTransporteAdaptado"
                                        id="necessidadeTransporteAdaptado-nao" <c:if
                                        test="${deficiencia.necessidadeAdaptacao == false}">checked</c:if>>
                                    <label for="necessidadeAdaptacao-nao">Não</label>
                                </div>
                            </div>
                        </div>

                        <div class="ordem-formulario">
                            <label></label>
                            <textarea name="explicacaoNecessidadeAdaptacao" id="explicacaoNecessidadeAdaptacao" rows="4"
                                readonly>${deficiencia.explicacaoNecessidadeAdaptacao}</textarea>
                        </div>

                        <div class="ordem-formulario">
                            <label>Necessita de Adaptação no local de atendimento:</label>
                            <div class="radio align">
                                <div class="ordem-formulario centerX">
                                    <input disabled type="radio" value="true"
                                        name="necessidadeAdaptacaoLocalAtendimento"
                                        id="necessidadeAdaptacaoLocalAtendimento-sim" <c:if
                                        test="${deficiencia.necessidadeAdaptacaoLocalAtendimento == true}">checked
                                    </c:if>>
                                    <label for="necessidadeAdaptacaoLocalAtendimento-sim">Sim</label>
                                </div>
                                <div class="ordem-formulario centerX">
                                    <input disabled type="radio" value="false"
                                        name="necessidadeAdaptacaoLocalAtendimento"
                                        id="necessidadeAdaptacaoLocalAtendimento-nao" <c:if
                                        test="${deficiencia.necessidadeAdaptacaoLocalAtendimento == false}">checked
                                    </c:if>>
                                    <label for="necessidadeAdaptacaoLocalAtendimento-nao">Não</label>
                                </div>
                            </div>
                        </div>

                        <div class="ordem-formulario">
                            <label></label>
                            <textarea name="explicacaoNecessidadeAdaptacaoLocalAtendimento"
                                id="explicacaoNecessidadeAdaptacaoLocalAtendimento" rows="4"
                                readonly>${deficiencia.explicacaoNecessidadeAdaptacaoLocalAtendimento}</textarea>
                        </div>

                        <div class="ordem-formulario">
                            <label for="necessidadeApoioEducacional">Necessita de apoio educacional:</label>
                            <div class="radio align">
                                <div class="ordem-formulario">
                                    <input disabled type="radio" name="necessidadeApoioEducacional"
                                        id="necessidadeApoioEducacional-sim" value="true" <c:if
                                        test="${deficiencia.necessidadeEducacional == true}">checked</c:if>>
                                    <label for="necessidadeApoioEducacional-sim">Sim</label>
                                </div>
                                <div class="ordem-formulario">
                                    <input disabled type="radio" name="necessidadeApoioEducacional"
                                        id="necessidadeApoioEducacional-nao" value="false" <c:if
                                        test="${deficiencia.necessidadeEducacional == false}">checked</c:if>>
                                    <label for="necessidadeApoioEducacional-nao">Não</label>
                                </div>
                            </div>
                        </div>

                        <div class="ordem-formulario">
                            <label></label>
                            <textarea name="necessidadeEducacional" id="necessidadeEducacional" rows="4"
                                readonly>${deficiencia.explicacaonecessidadeEducacional}</textarea>
                        </div>

                        <div class="ordem-formulario">
                            <label for="necessidadeAcompanhante">Necessita de acompanhante/responsável:</label>
                            <div class="radio align">
                                <div class="ordem-formulario centerX">
                                    <input disabled type="radio" value="true" name="necessidadeAcompanhante"
                                        id="necessidadeAcompanhante-sim" <c:if
                                        test="${deficiencia.necessidadeAcompanhante == true}">checked</c:if>>
                                    <label for="necessidadeAcompanhante-sim">Sim</label>
                                </div>
                                <div class="ordem-formulario centerX">
                                    <input disabled type="radio" value="false" name="necessidadeAcompanhante"
                                        id="necessidadeAcompanhante-nao" <c:if
                                        test="${deficiencia.necessidadeAcompanhante == false}">checked</c:if>>
                                    <label for="necessidadeAcompanhante-nao">Não</label>
                                </div>
                            </div>
                        </div>
                    </form>


                    <!-- Informações do Responsável -->
                    <form class="section-template"
                        action="/cadastromunicipal/controleuser?acao=atualizar-dadosreponsavel" method="POST"
                        autocomplete="on">
                        <input type="hidden" name="codigo" value="${usuarioPcd.codigo}">
                        <div class="Titulo-form">
                            <h3>Responsável</h3>
                            <i class="fas fa-edit edit-icon"></i> <!-- Ícone de editar -->
                        </div>

                        <div class="ordem-formulario">
                            <label>Nome Completo:</label>
                            <input type="text" name="nomecompletoResponsavel" id="nomecompletoResponsavel"
                                value="${responsavel.nomeCompleto}" readonly><br>
                        </div>

                        <div class="ordem-formulario">
                            <label>Email:</label>
                            <input type="email" name="emailResponsavel" id="emailResponsavel"
                                value="${responsavel.email}" readonly><br>
                        </div>

                        <div class="ordem-formulario">
                            <label>Endereço:</label>
                            <input type="text" name="enderecoResponsavel" value="${responsavel.endereco}" readonly><br>
                        </div>

                        <div class="ordem-formulario">
                            <label>Telefone:</label>
                            <input type="text" name="telefoneResponsavel" id="telefoneResponsavel"
                                value="${responsavel.telefone}" readonly><br>
                        </div>
                    </form>
                </div>

                <a href="/cadastromunicipal/page?pagina=authenticacao">Excluir conta</a>


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
            <script src="/cadastromunicipal/pagina/js/perfil.js"></script>
        </body>

        </html>