<?php
    include 'header.php';
?>

	<!-- //banner --> 
	<!-- banner-bottom -->


	<?php include 'slider.php'?>
	<!-- //banner-bottom --> 
	<!-- modal-video -->
	<!-- //modal-video -->
	<!-- banner-bottom1 -->

	<!-- //new-products -->
	<!-- top-brands -->
	<div class="top-brands">
		<div class="container">
			<h3>Top Brands</h3>
			<div class="sliderfig">
				<ul id="flexiselDemo1">			
					<li>
						<img src="images/H&Mlogo.jpeg" alt=" " class="img-responsive" />
					</li>
					<li>
						<img src="images/offwhitelogo.jpg" alt=" " class="img-responsive" />
					</li>
					<li>
						<img src="images/Zara.png" alt=" " class="img-responsive" />
					</li>
					<li>
						<img src="images/uniqlologo.png" alt=" " class="img-responsive" />
					</li>
					<li>
						<img src="images/pullnbearlogo.jpg" alt=" " class="img-responsive" />
					</li>
				</ul>
			</div>
			<script type="text/javascript">
					$(window).load(function() {
						$("#flexiselDemo1").flexisel({
							visibleItems: 4,
							animationSpeed: 1000,
							autoPlay: true,
							autoPlaySpeed: 3000,    		
							pauseOnHover: true,
							enableResponsiveBreakpoints: true,
							responsiveBreakpoints: { 
								portrait: { 
									changePoint:480,
									visibleItems: 1
								}, 
								landscape: { 
									changePoint:640,
									visibleItems:2
								},
								tablet: { 
									changePoint:768,
									visibleItems: 3
								}
							}
						});
						
					});
			</script>
			<script type="text/javascript" src="js/jquery.flexisel.js"></script>
		</div>
	</div>
	<!-- //top-brands --> 
	<!-- newsletter -->
	<?php include 'footer.php' ?>
