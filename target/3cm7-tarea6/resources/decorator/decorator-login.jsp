<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:sitemesh="http://www.sitemesh.org/schema/sitemesh-config"
	version="2.0">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<jsp:text>
		<![CDATA[ <?xml version="1.0" encoding="UTF-8" ?> ]]>
	</jsp:text>
	<jsp:text>
		<![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]>
	</jsp:text>
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>SB Admin - Dashboard</title>
<jsp:text>
	<!-- Bootstrap core CSS-->
	<link
		href="${pageContext.request.contextPath}/resources/themes/sb-admin/vendor/bootstrap/css/bootstrap.min.css"
		rel="stylesheet" />

	<!-- Custom fonts for this template-->
	<link
		href="${pageContext.request.contextPath}/resources/themes/sb-admin/vendor/fontawesome-free/css/all.min.css"
		rel="stylesheet" type="text/css" />

	<!-- Page level plugin CSS-->
	<link
		href="${pageContext.request.contextPath}/resources/themes/sb-admin/vendor/datatables/dataTables.bootstrap4.css"
		rel="stylesheet" />

	<!-- Custom styles for this template-->
	<link
		href="${pageContext.request.contextPath}/resources/themes/sb-admin/css/sb-admin.css"
		rel="stylesheet" />
</jsp:text>

<jsp:text>
	<script
		src="${pageContext.request.contextPath}/resources/themes/sb-admin/vendor/jquery/jquery.min.js">
	<!--// -->
		
	</script>
	<script
		src="${pageContext.request.contextPath}/resources/themes/sb-admin/vendor/bootstrap/js/bootstrap.bundle.min.js">
	<!--// -->
		
	</script>
	<script
		src="${pageContext.request.contextPath}/resources/themes/sb-admin/vendor/jquery-easing/jquery.easing.min.js">
	<!--// -->
		
	</script>
	<!--  <script
		src="${pageContext.request.contextPath}/resources/themes/sb-admin/vendor/chart.js/Chart.min.js"> -->
	<!--// -->
		
	<!-- </script>-->
	<script
		src="${pageContext.request.contextPath}/resources/themes/sb-admin/vendor/datatables/jquery.dataTables.js">
	<!--// -->
		
	</script>
	<script
		src="${pageContext.request.contextPath}/resources/themes/sb-admin/vendor/datatables/dataTables.bootstrap4.js">
	<!--// -->
		
	</script>
	<script
		src="${pageContext.request.contextPath}/resources/themes/sb-admin/js/sb-admin.min.js">
	<!--// -->
		
	</script>
	<script
		src="${pageContext.request.contextPath}/resources/themes/sb-admin/js/demo/datatables-demo.js">
	<!--// -->
		
	</script>
	<!-- <script
		src="${pageContext.request.contextPath}/resources/themes/sb-admin/js/demo/chart-area-demo.js">-->
	<!--// -->
		
	<!-- </script>-->
</jsp:text>

<sitemesh:write property="head" />
</head>
<body class="bg-dark">
	<sitemesh:write property="body" />
</body>
	</html>
</jsp:root>