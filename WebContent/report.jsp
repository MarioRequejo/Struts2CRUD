<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Exames</title>
<style>
table, td, th {border: 1px solid black;}
table {border-collapse: collapse;width: 60%;}
th {height: 30px;}
.button-update {background-color: #008CBA;color: white;}
.button-delete {background-color: red;color: white;}
</style>
</head>
<body>
	<h2>Exames</h2>
	<div style="margin-top: 40px;">
		<s:if test="noData==true">
			<table>
				<thead>
					<tr style="background-color: #E0E0E1;">
						<th>Pedido</th>
                    	<th>Paciente</th>
                    	<th>Médico</th>
                    	<th>Convênio</th>
                    	<th>Laudo</th>
                    	<th colspan="2">Ação</th>
					</tr>
				</thead>
				<s:iterator value="beanList">
					<tr>
						<td><s:property value="pedido"/></td>
                        <td><s:property value="pacienteMatr"/></td>
                        <td><s:property value="solicitanteCRM"/></td>
                        <td><s:property value="convenio"/></td>
                        <td><s:property value="laudo"/></td>
						<td>
							<a href="updatedetails.action?submitType=updatedata&pedido=<s:property value="pedido"/>">
								<button class="button-update">Editar</button>
							</a>
                        <td>
                            <a onclick="return confirm('Tem certeza?')" href="deleterecord.action?pedido=<s:property value="pedido"/>">
                            	<button class="button-delete">Excluir</button>
                            </a>
                        </td>
					</tr>
				</s:iterator>
			</table>
		</s:if>
		<s:else>
			<div style="color: red;">No Data Found.</div>
		</s:else>
	</div>
</body>
</html>