<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form   action ="successpost"  method="post">


<pre>

    auth_token:         <input type="text name="auth_token">
	item_name:          <input type="text name="item_name">
	from_name:          <input type="text name="from_name">
    from_phone_number:  <input type="text name="from_phone_number">
	from_address  :     <input type="text name="from_address">
	from_pincode  :     <input type="text name="from_pincode">
	pickup_gstin :      <input type="text name="pickup_gstin">
	to_name    :        <input type="text name="to_name">
	to_phone_number  :  <input type="text name="to_phone_number">
	to_pincode:         <input type="text name="to_pincode">
	to_address:         <input type="text name="to_address">
    quantity :          <input type="text name="quantity">
	invoice_value :     <input type="text name="invoice_value">


<input type="submit"  value="submit">
</pre>

</form>
</body>
</html>