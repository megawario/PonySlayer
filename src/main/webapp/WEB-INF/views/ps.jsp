<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="pt" ng-app="ponyslayer">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="resources/jquery-3.1.1.min.js"></script>
<script src="resources/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">

<!-- angular scripts -->
<script src="resources/angular.min.js"></script>
<script src="resources/app.js"></script>
<script src="resources/controllers.js"></script>
<script src="resources/services.js"></script>
<script src="resources/filters.js"></script>


<link rel="stylesheet" href="resources/bootstrap.min.css">
<link rel="stylesheet" href="resources/bootstrap-theme.min.css">

<link rel="stylesheet" type="text/css"
	href="resources/adventure_form.css">
<link rel="stylesheet" type="text/css"
	href="resources/adventure_panel.css">
<link rel="stylesheet" type="text/css" href="resources/components.css">



</head>
<body>

	<div class="jumbotron">
		<h1>Grupo de Roleplayers de Lisboa</h1>
		<h3>Marca&ccedil;&atilde;o de sess&otilde;es</h3>
		<div style="text-align: center;">
			<button type="button" class="btn btn-default btn-primary"
				data-toggle="modal" data-target="#createModal">Adicionar
				uma aventura</button>
		</div>
	</div>

	<!-- Adventure Content -->
	<div class="container" ng-controller="adventuresController as advCont">
		<div class="adventure-panel-container">
			<div class="row" ng-repeat="item in advCont.adventures">
				<div class="col-sm-6 col-md-3 infocard"
					ng-repeat="adventure in item">
					<div class="thumbnail">
						<div class="top-element">
							<img
								src="http://pre11.deviantart.net/c7e5/th/pre/f/2017/053/2/0/la_croix_du_chevalier_by_clock_dream-dazztuk.png"
								alt="image Text" />
							<div class="btn-group">
								<button type="button" class="btn btn-danger">Info</button>
								<button type="button" class="btn btn-danger dropdown-toggle"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">
									<span class="caret"></span> <span class="sr-only">Toggle Dropdown</span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="" ng-click="advCont.removeAdventure(adventure.id)">Apagar</a></li>
									<li><a href="#">Another action</a></li>
									<li><a href="#">Something else here</a></li>
									<li role="separator" class="divider"></li>
									<li><a href="#">Separated link</a></li>
								</ul>
							</div>

							<!-- Info Icons -->
							<div class="infoIcons pull-right">
								<div>
									<span><i class="material-icons">account_circle</i>
										<h4 title="{{adventure.dmName}}">{{adventure.dmName |
											cutwords:true:12:'...'}}</h4> </span>
								</div>
								<div>
									<span><i class="material-icons">schedule</i>
										<h4>{{adventure.timeStart}} - {{adventure.timeEnd}}</h4></span>
								</div>
								<div>
									<span><i class="material-icons">group</i>
										<h4>{{adventure.slotMin}} - {{adventure.slotMax}}</h4></span>
								</div>
								<div class="selectionButtons">
									<span><button class="btn btn btn-default btn-small">
											<i class="material-icons">info</i>
										</button></span> <span><button class="btn btn btn-default btn-small">
											<i class="material-icons">add</i>
										</button></span>
								</div>
								<div></div>
							</div>

						</div>
						<div class="caption">
							<h4 title="{{adventure.adventureTitle}}">{{adventure.adventureTitle|cutwords:true:12:'...'}}"</h4>
							<h5 title="{{adventure.subtitle}}">{{adventure.subtitle|cutwords:true:20:'...'}}}}"</h5>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<!-- Create adventure dialog modal -->
	<div class="modal fade" id="createModal" tabindex="-1" role="dialog"
		aria-labelledby="myCreateModalLabel"
		ng-controller="formController as fc">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<form novalidate ng-submit="fc.update(adventure)">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myCreateModalLabel">Criar uma
							aventura nova</h4>
					</div>
					<div class="modal-body">
						<div class="lisFeedBack">
							<ul class="alert alert-danger">
								<li ng-repeat="err in fc.error">{{err}}</li>
							</ul>
						</div>

						<div class="input-group input-group-lg">
							<span class="input-group-addon" id="name_icon"><i
								class="material-icons">account_circle</i></span> <input
								ng-model="adventure.dmName" class="form-control" type="text"
								placeholder="nome do DM (max 20 chars)"
								aria-describedby="name_icon" />
						</div>

						<div class="input-group input-group-lg">
							<span class="input-group-addon" id="add_system"><i
								class="material-icons">extension</i></span> <input type="text"
								name="add_system" class="form-control"
								ng-model="adventure.system"
								placeholder="sistema de jogo (max 100 chars)"
								aria-describedby="add_system" />
						</div>
						<div class="input-group input-group-lg">
							<span class="input-group-addon" id="add_aventure"><i
								class="material-icons">explore</i></span> <input
								ng-model="adventure.title" type="text" name="add_adventure"
								class="form-control" placeholder="aventura (max 100 chars)"
								aria-describedby="add_aventure" />
						</div>
						
						<!-- <div class="input-group input-group-lg">
							<span class="input-group-addon" id="add_time_start"> <i
								class="material-icons">schedule</i>
							</span> <select class="form-control" ng-model="adventure.timeStart"></select>
							<span class="input-group-addon" id="add_time_end">até</span> <select
								class="form-control" ng-model="adventure.timeEnd"></select>
						</div> -->
						
						<div class="input-group input-group-lg">
							<span class="input-group-addon"><i class="material-icons">group</i></span>
							<input ng-model="adventure.slotMin" class="form-control"
								placeholder="vaga minima" /> <span class="input-group-addon"
								id="add_slots_max">até</span> <input
								ng-model="adventure.slotMax" name="add_slots_max"
								class="form-control" placeholder="vagas maximas">
						</div>
						<div class="input-group input-group-lg">
							<span class="input-group-addon" id="add_image"><i
								class="material-icons">photo</i></span> <input
								ng-model="adventure.image" type="text" name="add_image"
								class="form-control"
								placeholder="url de imagem (200x200 centrada)"
								aria-describedby="add_aventure">
						</div>
						<div class="input-group input-group-lg">
							<span class="input-group-addon"><i class="material-icons">description</i></span>
							<textarea ng-model="adventure.synopsis"
								class="form-control text ui-widget-content ui-corder-all form-synopsis"
								placeholder="Resumo da aventura" name="adv_synopsis"
								maxlength="2000"></textarea>
						</div>


					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<input class="btn btn-default btn-primary" type="submit"
							value="Criar" />
					</div>
				</form>
			</div>
		</div>
	</div>

	

	<footer class="footer">
	<div class="container well">
		<p>
			This is a community project. Feel free to fork it and edit for your
			purposes!! <a href="https://github.com/megawario/awesome-sauce">Fork
				me!!!</a>
		</p>
	</div>
	</footer>

</body>
</html>