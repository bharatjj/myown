<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>




<body>


<table  border="5px ">
 
<tr>

<th>   authToken</th>
   
    <th>from_name</th>
    
     <th>from_phone_number</th>
     
      <th>from_pincode</th>
      
       <th>pickup_gstin</th>

</tr>
<c:forEach var = "all" items="${all}">

<tr>


   <td>   ${all.authToken}</td>
   
    <td>${all.from_name}</td>
    
     <td>${all.from_phone_number}</td>
     
      <td>${all.from_pincode}</td>
      
       <td>${all.pickup_gstin}</td>





</tr>

</c:forEach>




</table>





</body>



</html>