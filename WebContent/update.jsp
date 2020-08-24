<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Editar</title>
</head>
<body>
	<h2>Editar Exame</h2>
	<form action=updatedetails method="post">
		<pre>
<input type="hidden" name="exame.pedido" value='<s:property value="exame.pedido"/>'>
<b>Matrícula do Paciente:  </b><input type="text" name="exame.pacienteMatr" value='<s:property value="exame.pacienteMatr"/>'>
		
<b>CRM do solicitante:     </b><input type="text" name="exame.solicitanteCRM" value='<s:property value="exame.solicitanteCRM"/>'>
	
<b>Convênio:  </b><input type="text" name="exame.convenio" value='<s:property value="exame.convenio"/>'>

<b>Laudo:  </b><input type="text" name="exame.laudo" value='<s:property value="exame.laudo"/>'>	
		<button name="submitType" value="update" type="submit">Atualizar</button>
		</pre>
	</form>
	<s:if test="ctr>0">
		<span style="color: red;"><s:property value="msg" /></span>
	</s:if>
	<s:else>
		<span style="color: red;"><s:property value="msg" /></span>
	</s:else>
</body>
</html>