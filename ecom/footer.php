<?php
/**
 * Footer File of Template
 * Created by PhpStorm.
 * User: Tanjil Hasan
 * Date: 9/8/2017
 * Time: 6:12 AM
 */
?>

<!-- //newsletter -->
<!-- footer -->
<div class="footer">
    <div class="container">
        <div class="w3_footer_grids">
            <div class="col-md-3 w3_footer_grid">
                <h3>Contact</h3>
                <p>Do You Want to match ur style? or do you want reccomend product? please contact us +6812234567</p>
            </div>
            <div class="col-md-3 w3_footer_grid">
                <h3>Information</h3>
                <ul class="info">
                    <li><a href="about.php">About Us</a></li>
                    <li><a href="mail.php">Contact Us</a></li>
                    <li><a href="faq.php">FAQ's</a></li>
                    <li><a href="products.php">Special Products</a></li>
                </ul>
            </div>
            <div class="col-md-3 w3_footer_grid">
                <h3>Category</h3>
                <ul class="info">
                    <li><a href="products.php">Jaket</a></li>
                    <li><a href="products.php">Hoodie</a></li>
                    <li><a href="products.php">Sweater</a></li>

                </ul>
            </div>
            <div class="col-md-3 w3_footer_grid">
                <h3>Profile</h3>
                <ul class="info">
                    <li><a href="index.php">Home</a></li>
                    <li><a href="products.php">Today's Deals</a></li>
                </ul>
                <h4>Follow Us</h4>
                <div class="agileits_social_button">
                    <ul>
                        <?php $social = $allCategoryObject->allSocialMediaLinks();  if (!$social): ?>
                            <li><a href="#" class="facebook">  </a></li>
                            <li><a href="#" class="twitter"> </a></li>
                            <li><a href="#" class="google"> </a></li>
                            <li><a href="#" class="pinterest"> </a></li>
                        <?php else:  ?>
                            <?php while ($link = $social->fetch_assoc()): ?>
                                <li><a href="<?php echo $link['link']; ?>" class="fa <?php echo $link['icon']; ?> fa-2x">  </a></li>
                            <?php endwhile; ?>
                        <?php endif ?>
                    </ul>
                </div>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
    <div class="footer-copy">
        <div class="footer-copy1">
            <div class="footer-copy-pos">
                <a href="#home1" class="scroll"><img src="images/arrow.png" alt=" " class="img-responsive" /></a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
