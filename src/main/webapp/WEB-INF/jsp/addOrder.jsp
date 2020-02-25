<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>



</head>

<body>



<form:form   action="orderpost"  modelAttribute="razorOrderPost">

Amount:<form:input type="text" path="amount"/>

Currency:<form:input type="text" path="currency"/>
Receipt:<form:input type="text" path="receipt"/>

    <input type="submit" value="save"/>




</form:form>


</body>




</html>