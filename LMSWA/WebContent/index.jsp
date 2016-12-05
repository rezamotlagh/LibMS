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
<link rel="stylesheet" href="pageStyles.css">
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
            <h1>LMS</h1>
        <p>A system to manage and maintain our Library </p>
        
    </div>
    <div class="row">
        <div class="col-xs-4">
            <h3>Administrator</h3>
            <p><a href="" target="_blank" class="btn btn-default">Login</a></p>
        </div>
        <div class="col-xs-4">
            <h3>Borrower</h3>
            <form class="form-horizontal" method='post' action="SimpleServlet">
            <div class="form-group">
                                   
                         <input type="text" name="borrowerName" class="form-control col-sm-8 col-md-8" id="cardNo" placeholder="Enter CardNo">
                   
            </div>
                  <div class="form-group"> 
                    <div class="col-sm-offset-2 col-sm-10">
                      <button type="submit" class="btn btn-default">Submit</button>
                    </div>
                  </div>
            </form>
        </div>
        <div class="col-xs-4">
            <h3>Librarian</h3>
            <form class="form-horizontal" method='post' action="LibrarianDashboard.jsp">
            <div class="form-group">
                        <select class="form-control" name="branchMenu" id="branchMenu">
                            <option value="" disabled="disabled">Select a branch</option>
                            <option value="1.University Library,Boston">University Library, Boston</option>
                            <option value="2.State Library,New York">State Library, New York</option>
                            <option value="3.Federal Library, Washington DC">Federal Library, Washington DC</option>
                            <option value="4.County Library, McLean VA">County Library, McLean VA</option>
                          </select>
                            
                   
            </div>
                  <div class="form-group"> 
                    <div class="col-sm-offset-2 col-sm-10">
                      <button type="submit" class="btn btn-default">Submit</button>
                    </div>
                  </div>
            </form>
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