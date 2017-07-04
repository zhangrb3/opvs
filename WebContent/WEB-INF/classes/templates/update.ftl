<html>
<head><title>修改用户</title></head>
<body>
修改用户
     <form method="post" action="/user/update">
           id：<input type="text" name="id" value=${user.id} /><br />
           username: <input type="text" name="username" value=${user.username} /><br />
           age: <input type="text" name="age" value=${user.age} /><br />
           <input type="submit" value="修改" />
           <input type="reset" value="重置" />
     </form>
</body>
</html>

