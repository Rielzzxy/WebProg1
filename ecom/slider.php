<?php
/**
 * Slider Page of Template
 * Created by PhpStorm.
 * User: Tanjil Hasan
 * Date: 9/8/2017
 * Time: 6:34 AM
 */
?>
        </div>
        <div class="col-md-7 wthree_banner_bottom_right">
            <div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
                <ul id="myTab" class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active">
                        <a href="#home" id="home-tab" role="tab" data-toggle="tab" aria-controls="home">Hoodie</a>
                    </li>
                    <li role="presentation">
                        <a href="#audio" role="tab" id="audio-tab" data-toggle="tab" aria-controls="audio">Jaket</a>
                    </li>
                    <li role="presentation">
                        <a href="#video" role="tab" id="video-tab" data-toggle="tab" aria-controls="video">Sweater</a>
                    </li>
                </ul>
                <div id="myTabContent" class="tab-content">
                    <div role="tabpanel" class="tab-pane fade active in" id="home" aria-labelledby="home-tab">
                        <div class="agile_ecommerce_tabs">
                            <?php $allPro = $productObject->showjaketProduct(); if ($allPro): ?>
                                <?php while ($mobile = $allPro->fetch_assoc()): ?>
                                <div class="col-md-4 agile_ecommerce_tab_left">
                                    <div class="hs-wrapper">
                                        <?php for ($i = 1; $i <= 8; ++$i): ?>
                                            <img src="admin/<?php echo $mobile['image'];?>" alt=" " class="img-responsive" />
                                        <?php endfor; ?>
                                    </div>
                                    <div style="margin-top: 10px; margin-bottom: 10px">
                                        <h5><a href="single.php?proid=<?php echo $mobile['proid'];?>" target="_blank" ><?php echo $mobile['proname'];?></a></h5>
                                        <h3> $ <?php echo $mobile['price'];?></h3>
                                    </div>
                                    <div class="" style="margin-top: 10px">
                                        <a href="single.php?proid=<?php echo $mobile['proid'];?>" target="_blank" class="btn btn-info">Details</a>
                                    </div>
                                </div>
                                <?php endwhile; ?>
                            <?php endif; ?>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="audio" aria-labelledby="audio-tab">
                        <div class="agile_ecommerce_tabs">
                            <div class="agile_ecommerce_tabs">
                                <?php $allPro = $productObject->showHoodieProduct(); if ($allPro): ?>
                                    <?php while ($mobile = $allPro->fetch_assoc()): ?>
                                        <div class="col-md-4 agile_ecommerce_tab_left">
                                            <div class="hs-wrapper">
                                                <?php for ($i = 1; $i <= 8; ++$i): ?>
                                                    <img src="admin/<?php echo $mobile['image'];?>" alt=" " class="img-responsive" />
                                                <?php endfor; ?>
                                            </div>
                                            <div style="margin-top: 10px; margin-bottom: 10px">
                                                <h5><a href="single.php?proid=<?php echo $mobile['proid'];?>" target="_blank" ><?php echo $mobile['proname'];?></a></h5>
                                                <h3> $ <?php echo $mobile['price'];?></h3>
                                            </div>
                                            <div class="" style="margin-top: 10px">
                                                <a href="single.php?proid=<?php echo $mobile['proid'];?>" target="_blank" class="btn btn-info">Details</a>
                                            </div>
                                        </div>
                                    <?php endwhile; ?>
                                <?php endif; ?>
                                <div class="clearfix"> </div>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="video" aria-labelledby="video-tab">
                        <div class="agile_ecommerce_tabs">
                            <?php $allPro = $productObject->showSweaterProduct(); if ($allPro): ?>
                                <?php while ($mobile = $allPro->fetch_assoc()): ?>
                                    <div class="col-md-4 agile_ecommerce_tab_left">
                                        <div class="hs-wrapper">
                                            <?php for ($i = 1; $i <= 8; ++$i): ?>
                                                <img src="admin/<?php echo $mobile['image'];?>" alt=" " class="img-responsive" />
                                            <?php endfor; ?>
                                        </div>
                                        <div style="margin-top: 10px; margin-bottom: 10px">
                                            <h5><a href="single.php?proid=<?php echo $mobile['proid'];?>" target="_blank" ><?php echo $mobile['proname'];?></a></h5>
                                            <h3> $ <?php echo $mobile['price'];?></h3>
                                        </div>
                                        <div class="" style="margin-top: 10px">
                                            <a href="single.php?proid=<?php echo $mobile['proid'];?>" target="_blank" class="btn btn-info">Details</a>
                                        </div>
                                    </div>
                                <?php endwhile; ?>
                            <?php endif; ?>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="tv" aria-labelledby="tv-tab">
                        <div class="agile_ecommerce_tabs">
                            <?php $allPro = $productObject->showHouseholdProduct(); if ($allPro): ?>
                                <?php while ($mobile = $allPro->fetch_assoc()): ?>
                                    <div class="col-md-4 agile_ecommerce_tab_left">
                                        <div class="hs-wrapper">
                                            <?php for ($i = 1; $i <= 8; ++$i): ?>
                                                <img src="admin/<?php echo $mobile['image'];?>" alt=" " class="img-responsive" />
                                            <?php endfor; ?>
                                        </div>
                                        <div style="margin-top: 10px; margin-bottom: 10px">
                                            <h5><a href="single.php?proid=<?php echo $mobile['proid'];?>" target="_blank" ><?php echo $mobile['proname'];?></a></h5>
                                            <h3> $ <?php echo $mobile['price'];?></h3>
                                        </div>
                                        <div class="" style="margin-top: 10px">
                                            <a href="single.php?proid=<?php echo $mobile['proid'];?>" target="_blank" class="btn btn-info">Details</a>
                                        </div>
                                    </div>
                                <?php endwhile; ?>
                            <?php endif; ?>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="kitchen" aria-labelledby="kitchen-tab">
                        <div class="agile_ecommerce_tabs">
                            <?php $allPro = $productObject->showKitchenProduct(); if ($allPro): ?>
                                <?php while ($mobile = $allPro->fetch_assoc()): ?>
                                    <div class="col-md-4 agile_ecommerce_tab_left">
                                        <div class="hs-wrapper">
                                            <?php for ($i = 1; $i <= 8; ++$i): ?>
                                                <img src="admin/<?php echo $mobile['image'];?>" alt=" " class="img-responsive" />
                                            <?php endfor; ?>
                                        </div>
                                        <div style="margin-top: 10px; margin-bottom: 10px">
                                            <h5><a href="single.php?proid=<?php echo $mobile['proid'];?>" target="_blank" ><?php echo $mobile['proname'];?></a></h5>
                                            <h3> $ <?php echo $mobile['price'];?></h3>
                                        </div>
                                        <div class="" style="margin-top: 10px">
                                            <a href="single.php?proid=<?php echo $mobile['proid'];?>" target="_blank" class="btn btn-info">Details</a>
                                        </div>
                                    </div>
                                <?php endwhile; ?>
                            <?php endif; ?>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
