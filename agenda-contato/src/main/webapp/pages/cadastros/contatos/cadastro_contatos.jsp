<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>

<mt:admin_template title="Contatos" breadcrumb="Dashboard">

	<jsp:attribute name="content">
		
     	<div class="row">
          <div class="col-lg-12">
            <div class="p-5">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">Novo Contato</h1>
              </div>
              <form class="user" method="post" action="${pageContext.request.contextPath}/contatoControllerServlet">
                <div class="form-group">
                  <div class="col-sm-12 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" 
                    id="nome" placeholder="Digite seu Nome" required="required" name="nome" value="${contato.nome}" <c:if test="${opcao.equals('visualizar')}"> readonly="readonly"</c:if>>
                    </div>
                </div>
                <div class="form-group">
                	<div class="col-sm-12 mb-3 mb-sm-0">
                  		<input type="email" class="form-control form-control-user" 
                  		id="email" placeholder="Digite seu Email" required="required" name="email" value="${contato.email}" <c:if test="${opcao.equals('visualizar')}"> readonly="readonly"</c:if>>
                  	</div>
                </div>
                <div class="form-group">
                  <div class="col-sm-12 mb-3 mb-sm-0">
                  	<input	type="hidden" value="${contato.id}" name="id">
                    <input type="text" class="form-control form-control-user" 
                    id="telefone" placeholder="Digite seu Telefone" required="required" name="telefone" value="${contato.telefone}" <c:if test="${opcao.equals('visualizar')}"> readonly="readonly"</c:if>>
                  </div>
                </div>
                <div align="center">
                    <input type="${opcao.equals('visualizar') ? 'hidden' : 'submit' }" class="btn btn-success" value="Salvar">
                    <a href="${pageContext.request.contextPath}/contatoControllerServlet" class="btn btn-primary">Voltar</a>
                </div>
              </form>
            </div>
          </div>
        </div>
					
	</jsp:attribute>

</mt:admin_template>
