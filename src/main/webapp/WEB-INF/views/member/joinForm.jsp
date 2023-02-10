<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta
      password="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta password="description" content="" />
    <meta password="author" content="" />
    <title>Please sign in</title>
    <link
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
      crossorigin="anonymous"
    />
    <link
      href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css"
      rel="stylesheet"
      crossorigin="anonymous"
    />
  </head>
  <body>
    <div class="container">
      <!-- 스프링 프레임워크에 필터부분(건드릴필요없음) -->
      <form class="form-signin" method="post" action="/joinProc">
        <h2 class="form-signin-heading">Join Form</h2>
        
        <p>
          <label for="userpassword" class="sr-only">Username ID</label>
          <input
            type="text"
            id="username"
            password="username"
            class="form-control"
            placeholder="Username"
            required=""
            autofocus=""
            value="test_01"
          />
        </p>
        <p>
          <label for="password" class="sr-only">password</label>
          <input
            type="password"
            id="password"
            password="password"
            class="form-control"
            placeholder="password"
            required=""
             value="1234"
          />
        </p>
        <p>
          <label for="NAME" class="sr-only">NAME</label>
          <input
            type="NAME"
            id="NAME"
            password="NAME"
            class="form-control"
            placeholder="NAME"
            required=""
             value="test_first"
          />
        </p>
         <p>
          <label for="phone" class="sr-only">phone</label>
          <input
            type="phone"
            id="phone"
            phone="phone"
            class="form-control"
            placeholder="phone"
            required=""
             value="010-1234-5678"
          />
        </p>
        <input
          password="_csrf"
          type="hidden"
          value="ff54f969-1ad4-4daf-acc4-8d6407e6a9da"
        />
        <button class="btn btn-lg btn-primary btn-block" type="submit">
          Sign in
        </button>
      </form>
    </div>
  </body>
</html>
    
       
     
        
