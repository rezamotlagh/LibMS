<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap 3 Fixed Layout Example</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<style type="text/css">
    body{
        padding-top: 70px;
    }
</style>
</head>
<body>
<nav id="myNavbar" class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbarCollapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">LMS</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="index.html" target="_blank">Home</a></li>
                <li><a href="about.html" target="_blank">About</a></li>
                <li><a href="contact.html" target="_blank">Contact</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="jumbotron">
       
        <p>Hello Librarian!<br/> Welcome to the branch <%out.println(request.getParameter("branchMenu")); %> </p>
       
    </div>
    <div class="row">
        
        <div class="col-xs-12">
                <ul class="nav nav-tabs">
                    <li class="active"><a data-toggle="tab" href="#home">Home</a></li>
                    <li><a data-toggle="tab" href="#updateLibDetails">Update Details of the Branch</a></li>
                    <li><a data-toggle="tab" href="#addBookCopies">Add Book copies</a></li>
                </ul>

                        <div class="tab-content">
                          <div id="home" class="tab-pane fade in active">
                            <h3>Librarian Dashboard</h3>
                            <p>In this page you can Manage this branch.
                                <br/>Select one of the tabs. </p>
                          </div>
                          <div id="updateLibDetails" class="tab-pane fade">
                            <h3>Update Details of the Branch</h3>
                              <p>Enter new details or leave any of the fields for no change</p>
                            <form>
                              <div class="form-group">
                                <label for="branchName">Enter a new branch name:</label>
                                <input type="text" class="form-control" id="branchName">
                              </div>
                              <div class="form-group">
                                <label for="pwd">Enter a new branch address:</label>
                                <input type="text" class="form-control" id="branchAddress">
                              </div>
                              
                              <button type="submit" class="btn btn-default">Apply</button>
                            </form>
                          </div>
                          <div id="addBookCopies" class="tab-pane fade">
                            <h3>Add Book Copies</h3>
                            <p>Select a Book</p>
                          </div>
                        </div>
        </div>
      
    <hr>
    <div class="row">
        <div class="col-xs-12">
            <footer>
                
            </footer>
        </div>
    </div>
</div>
</body>
</html>                                     