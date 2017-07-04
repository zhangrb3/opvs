<html>
<head><title>用户管理首页</title></head>
<a href="/user/adduser">添加用户</a>
     <table border=1>
         <tr>
             <td>用户id</td>
             <td>用户名</td>
             <td>年龄</td>
             <td>操作</td>
             <td>操作</td>
         </tr>
         <#list users as user>
             <tr>
                 <td>${user.id}</td>
                 <td>${user.username}</td>
                 <td>${user.age}</td>
                 <td><a href="/user/updateuser/${user.id}">修改</a></td>
                 <td><a href="/user/del/${user.id}">删除</a></td>
             </tr>
         </#list>
     </table>
</body>
</html>