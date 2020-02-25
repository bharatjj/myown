
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html>



<head>




</head>


<body>

<c:forEach items="${razorpay_order_id}" var="razorpay_order_id">
    <c:out value="${razorpay_order_id}" default="Not Available" escapeXml="false"></c:out>
  </c:forEach>
<form action="https://www.example.com/payment/success/" method="POST">
<script
    src="https://checkout.razorpay.com/v1/checkout.js"
    data-key="rzp_test_z1DDpNKf3h1xsL" // Enter the Key ID generated from the Dashboard
    data-amount="${amount}" // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise or INR 500.
    data-currency="INR"
    data-order_id="${razorpay_order_id}"
    data-buttontext="Pay with Razorpay"
    data-name="Acme Corp"
    data-description="A Wild Sheep Chase is the third novel by Japanese author Haruki Murakami"
    data-image="https://example.com/your_logo.jpg"
    data-prefill.name="Gaurav Kumar"
    data-prefill.email="gaurav.kumar@example.com"
    data-prefill.contact="9999999999"
    data-theme.color="#F37254"
></script>
<input type="hidden" custom="Hidden Element" name="hidden">
</form>


</body>

</html>