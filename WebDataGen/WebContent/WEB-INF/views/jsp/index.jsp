<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta name="twitter:title" content="Online test data generator. Random test data 100.000 Records">
      <meta http-equiv="Expires" content="30">
      <meta name="theme-color" content="#ffffff">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Online test data generator. Random test data Records</title>
      <spring:url value="/resources/core/css/css" var="fontCss" />      
      <link href="${fontCss}" rel="stylesheet">
      <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
      <link href="${bootstrapCss}" rel="stylesheet">
      <spring:url value="/resources/core/css/odgstyle.css" var="coreCss" />      
      <link href="${coreCss}" rel="stylesheet">
      <spring:url value="/resources/core/css/container.css" var="containerCss" />      
      <link href="${containerCss}" rel="stylesheet">
      <spring:url value="/resources/core/images/esys.png" var="esysimg" />
   </head>
   <body data-scroll="spy" class="" style="">
      <div class="intro  blue-bar-gradient">
         <div class="container">
            <div class="row">
               <div class="intro-text col-md-12 col-sm-12">
                  Welcome to
                  <h1>
                     <span>Online test data generator</span>
                  </h1>
               </div>
            </div>
         </div>
      </div>
      <section id="get-started" style="height: auto !important;">
         <div class="container" style="height: auto !important;">
         <div class="row" style="height: auto !important;">
            <div class="define-data col-lg-8 col-md-8 col-sm-12">
               <div class="row" style="min-height:290px">
                 <!--  <div class="define-data col-lg-12 col-md-12 col-sm-12">
                     <div class="step" style="display:inline!important">
                        <span>1</span> &nbsp;&nbsp; 
                        <h2>Upload Data</h2>
                     </div> -->
                     <div class="define-data-table" style="margin-top:10px">
                        <div id="example_wrapper" class="dataTables_wrapper">
									<form action="uploadDdlFile" method="post"
										enctype="multipart/form-data">
										<!--textarea name="ddlStr" cols="100" rows="9"  
                              		placeholder="Paste ddl text over here..">
						   		</textarea-->
						   		
						   		<div class="row">
											<div class="export-data col-lg-12 col-md-12 col-sm-12">
												<div class="step">
													<span>1</span> &nbsp;&nbsp;
													<h2>Upload data</h2>
												</div>
												<div class="export-form">
													<div class="row">
														<div class="col-md-5">
														Select Excel/CSV File:
														</div>
														<div class="col-md-5">
															<input type="file" name="ddlFile" class="btn btn-primary">
														</div>
													</div>
													</div>
													</div>
													</div>
										
										<div class="row">
											<div class="col-md-5">
												<p>
													<!--button type="submit" class="btn btn-primary" onclick="return buttonClicked()">Submit</button-->
													<!--input type="submit" class="btn btn-primary" value="Preview"/-->
												</p>
											</div>
											<div class="col-md-5"></div>
											<div class="col-md-2">
												<p>
													<!--button type="submit" class="btn btn-primary" onclick="resetColumns()">Reset</button-->
													<!--input type="reset" class="btn btn-primary" value="Clear"-->
												</p>
											</div>
										</div>
										<!-- Form end here -->
										<div class="row">
											<div class="export-data col-lg-12 col-md-12 col-sm-12">
												<div class="step">
													<span>2</span> &nbsp;&nbsp;
													<h2>Export data</h2>
												</div>
												<div class="export-form">
													<form action="export-form" autocomplete="off" method="post"></form>
													<div class="row">
														<div class="col-md-5">
															<label for="nr-rows-input">Rows</label>
														</div>
														<div class="col-md-5">
															<label for="export-type-dd">Export Type</label>
														</div>
														<div class="col-md-2"></div>
													</div>
													<div class="row">
														<div class="col-md-5">
															<input class="form-control number" data-val="true"
																data-val-number="The field NumberOfRecords must be a number."
																data-val-required="The NumberOfRecords field is required."
																id="NumberOfRecords" name="NumOfRecords" type="text"
																value="10"> <small id="rows-help"
																class="form-text text-muted">Choose how many
																rows do you want to generate</small>
														</div>
														<div class="col-md-5">
															<select class="form-control" id="ExportType"
																name="ExportType">
																<option>CSV</option>
																<option>Excel</option>
																<option>SQLInsert</option>
															</select> <small id="rows-help" class="form-text text-muted">Choose
																how your data will look like</small>
														</div>
														<div class="col-md-2">
															<p>
																<input type="submit" class="btn btn-primary"
																	value="Export" formaction="uploadDdlFile" />
															</p>
														</div>
													</div>
												</div>
											</div>
										</div>
									</form>
									<!--div class="row">
                              <div class="col-12 preview-container">
                                 <div class="step">
                                    <span>3</span> &nbsp;&nbsp; 
                                    <h2>Preview data live</h2>
                                 </div>
                                 <table class="table table-bordered" id="demoTable">
                                    <tbody>
                                       <tr>
                                          <th>ID</th>
                                          <th>Job Title</th>
                                          <th>Email Address</th>
                                          <th>FirstName LastName</th>
                                       </tr>
                                       <tr>
                                          <td>1</td>
                                          <td>Operator</td>
                                          <td>Angela_Mason8156@yahoo.com</td>
                                          <td>Angela Mason</td>
                                       </tr>
                                       <tr>
                                          <td>2</td>
                                          <td>Designer</td>
                                          <td>Bob_Radcliffe1036@gembat.biz</td>
                                          <td>Bob Radcliffe</td>
                                       </tr>
                                       <tr>
                                          <td>3</td>
                                          <td>Service Supervisor</td>
                                          <td>Sofia_Vince1921@gompie.com</td>
                                          <td>Sofia Vince</td>
                                       </tr>
                                    </tbody>
                                 </table>
                              </div-->
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
      </section>
      </div>
		<section id="about-app">
		    <div class="container">
		        <div class="row">
		            <div class="col-md-6 col-lg-6 col-sm-12">
		                <div class="title text-center">
		                    <h3>What is Online Data Generator?</h3>
		                    <div class="title-border">
		                        <span class="large"></span>
		                        <span class="medium"></span>
		                        <span class="small"></span>
		                    </div>
		                </div>
		                <div class="text-info text-info-left">
		                    <p>
		                        Online Data Generator is a free tool meant to help developers and testers to generate test data for software application. As such, you can generate realistic test data that includes: fake address or random postal address, books, movies, music, brand, business, colors, country, credit card, date and time, education, gender, identification number, money numbers, person random names, random email address, programming and internet.
		                        <br /> TThe test data generated by Online Data Generator tool looks realistic and that offers developers better accuracy when testing
		                    </p>
		                </div>
		            </div>
		            <div class="col-md-6 col-lg-6 col-sm-12">
		                <div class="title text-center">
		                    <h3>Why use Online Data Generator?</h3>
		                    <div class="title-border">
		                        <span class="large"></span>
		                        <span class="medium"></span>
		                        <span class="small"></span>
		                    </div>
		                </div>
		                <div>
		                    <p>
		                        You need test data, you can generate it with this tool!
		                        <ul>
		                            <li>It's a completely free tool! If you like it, you can show your appreciation by recommending us to others!</li>
		                            <li>Quick and efficient - no need to create an account or log in, just dive in and get to work!</li>
		                            <li>Five different export types (CSV, Excell, Json, SQLinsert and Xml) for your test data to suit everyone's needs.</li>
		                            <li>It makes it easier to show new features to clients, so they'll understand better.</li>
		                        </ul>
		                    </p>
		                </div>
		            </div>
		        </div>
		    </div>
		</section>
      <footer class="site-footer">
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-12 d-flex justify-content-start align-items-center">
                    <a href="http://www.foo.tech/" title="eSys technologies"><img src="${esysimg}" alt="Esys"> </a>
                </div>
                <div class="col-md-3 col-sm-12 justify-content-center copyright-p d-flex align-items-center order-sm-1"><p>Copyright &copy; 2019 eSystems.tech</p></div>
                <div class="col-md-3 col-sm-12 terms-p d-flex align-items-center justify-content-md-end justify-content-sm-center order-sm-2 justify-content-center"><a title="Terms and conditions" href="/Home/Terms">Terms and conditions</a></div>
                <div class="col-md-3 col-sm-12 terms-p d-flex align-items-center justify-content-md-end justify-content-sm-center order-sm-3 justify-content-center" style="margin-top:10px">
                    <a title="Contact us" href="/Home/Contact">Contact</a> <br />
                </div>
            </div>
            <div class="fb-like" data-href="https://www.facebook.com/OnlineDataGenerator" data-layout="button_count" data-action="like" data-size="small" data-show-faces="true" data-share="true"></div>
        </div>
    </footer>
   </body>
</html>