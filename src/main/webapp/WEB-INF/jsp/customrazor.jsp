
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html>



<head>

<script type="text/javascript" src="https://checkout.razorpay.com/v1/razorpay.js"></script>


</head>


<body>

<script>


var razorpay = new Razorpay({
	  key: 'rzp_test_SDEHu2hLHKpFXf',
	    // logo, displayed in the payment processing popup
	  image: 'https://i.imgur.com/n5tjHFD.png',
	});

</script>
<!-- 
<script>

var razorpay = new Razorpay({
	  key: 'rzp_test_SDEHu2hLHKpFXf',
razorpay.once('ready', function(response) {
  console.log(response.methods);
});

</script> -->


<script>

var data = {
		  amount: 1000, // in currency subunits. Here 1000 = 1000 paise, which equals to ₹10
		  currency: "INR"// Default is INR. We support more than 90 currencies.
		  email: "gaurav.klumar@example.com",
		  contact: '9123456780',
		  notes: {
		    address: 'Ground Floor, SJR Cyber, Laskar Hosur Road, Bengaluru',
		  },
		  order_id: 'order_E9dP6U6bZxX483',
		  method: 'netbanking',

		  // method specific fields
		  bank: 'HDFC'
		};

		$btn.on('click', function(){
		  // has to be placed within user initiated context, such as click, in order for popup to open.
		  razorpay.createPayment(data);

		  razorpay.on('payment.success', function(resp) {
		    alert(resp.razorpay_payment_id),
		    alert(resp.razorpay_order_id),
		    alert(resp.razorpay_signature)}); // will pass payment ID, order ID, and Razorpay signature to success handler.

		  razorpay.on('payment.error', function(resp){alert(resp.error.description)}); // will pass error object to error handler

		})

</script>

</body>

</html>