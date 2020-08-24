<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Register</title>
<style type="text/css">
.button-register {background-color: green;color: white;}
.button-report {background-color: #000000;color: white;margin-left: 30%;}
</style>
</head>
<body>
	<h2>Incluir Exame</h2>
	<a href="report"><button class="button-report" type="button">Exames</button></a>
	<s:form action="register.action" method="post">
		<s:textfield name="exame.pedido" label="Número do Pedido"/>
        <s:textfield name="exame.pacienteMatr" label="Matrícula do Paciente"/>
        <s:textfield name="exame.solicitanteCRM" label="CRM do solicitante"/>
        <s:textfield name="exame.convenio" label="Convênio"/>
        <s:textfield name="exame.laudo" label="Laudo"/>
		<s:submit cssClass="button-register" value="Salvar" />
	</s:form>
	<s:if test="ctr>0">
		<span style="color: green;"><s:property value="msg" /></span>
	</s:if>
	<s:else>
		<span style="color: red;"><s:property value="msg" /></span>
	</s:else>
</body>
</html>