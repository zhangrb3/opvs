<!DOCTYPE html>    
    
<html lang="en">    
    
<body>    
    Date: ${time?date}    
    <br>    
    Time: ${time?time}    
    <br>    
    Message: ${message}    
      
     ${content}  
        <table border="2">  
            <#list users as user>  
                <tr>
                <td>  
                        ${user.id}  
                    </td>    
                    <td>  
                        ${user.username}  
                    </td>   
                   
                    <td>  
                        ${user.age}  
                    </td>  
             
                </tr>  
            </#list>  
              
        </table>  
</body>    
    
</html>    