
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GymPhotos</title>
    <link rel="stylesheet" href="../../web/styless/baseStyles.css" type="text/css">
    <link rel="stylesheet" href="../../web/styless/client/clientProfileStyles.css" type="text/css">
    <link rel="stylesheet" href="../../web/styless/client/clientExerciseStyle.css" type="text/css">
    <link rel="stylesheet" href="../../web/styless/modalWindows.css" type="text/css">
    <link rel="stylesheet" href="../../web/styless/coach/coachesStyles.css" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Staatliches" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Oswald:300" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">
    <script src="../../web/scripts/pictureSelector.js"></script>
    <script src="../../web/scripts/buttonStyleChanger.js"></script>

</head>
<body>
<div id="wrapper">
    <jsp:include page="menu.jsp">
        <jsp:param name="pageTopic" value="gym_photos"/>
        <jsp:param name="currentPage" value="gym_photos"/>
    </jsp:include>
    <section>
        <div class="container">
            <div class="rightcolumn" style="min-height: 450px;">
                <div class="flex-container" style="flex-wrap: wrap;width: 600px;min-height: 500px">
                    <div class="flex-item">
                        <input class="modal__check" type="checkbox" id="modal0"/>
                        <div class="modal">
                            <label class="modal__closetwo" for="modal0"></label>
                            <div class="flex-container">
                                <div class="flex-item">
                                    <a href="##" onclick="setPreviousPicture(8)"><img src="../../web/images/gymPhotos/previousPicture.jpg" style="width: 80px; height: 80px;margin-top: -30px;"/></a>
                                </div>
                                <div class="flex-item" style="width: 900px;height: 550px;margin-top: -250px;">
                                    <div class="modal__info" style="height: 500px;">
                                        <label class="modal__close" for="modal0" id="closeLabel0" style="color: white">&times;</label>
                                        <img src="../../web/images/gymPhotos/photo1.jpg" style="margin-top:-20px;width: 900px;height: 550px;border-radius: 10px;margin-left: -20px;" alt="Our offices">
                                    </div>
                                </div>
                                <div class="flex-item" style="margin-left: -270px;">
                                    <a href="##" onclick="setNextPicture(1)"><img src="../../web/images/gymPhotos/nextPictures.jpg" style="width: 80px; height: 80px;margin-top: -30px;"/></a>
                                </div>
                            </div>
                        </div>
                        <label for="modal0"  style="width: 60px;height: 22px;padding-top: 10px;"><img src="../../web/images/gymPhotos/photo1.jpg" style="margin-top:-20px;width: 190px;height: 140px;border-radius: 10px;" alt="Our offices"></label>
                    </div>

                    <div class="flex-item" style="margin-left: 110px;">
                        <input class="modal__check" type="checkbox" id="modal1"/>
                        <div class="modal">
                            <label class="modal__closetwo" for="modal1"></label>
                            <div class="flex-container">
                                <div class="flex-item">
                                    <a href="##" onclick="setPreviousPicture(0)"><img src="../../web/images/gymPhotos/previousPicture.jpg" style="width: 80px; height: 80px;margin-top: -30px;"/></a>
                                </div>
                                <div class="flex-item" style="width: 900px;height: 550px;margin-top: -250px;">
                                    <div class="modal__info" style="height: 500px;">
                                        <label class="modal__close" for="modal1" id="closeLabel1" style="color: white">&times;</label>
                                        <img src="../../web/images/gymPhotos/photo2.jpg" style="margin-top:-20px;width: 900px;height: 550px;border-radius: 10px;margin-left: -20px;" alt="Our offices">
                                    </div>
                                </div>
                                <div class="flex-item" style="margin-left: -270px;">
                                    <a href="##" onclick="setNextPicture(2)"><img src="../../web/images/gymPhotos/nextPictures.jpg" style="width: 80px; height: 80px;margin-top: -30px;"/></a>
                                </div>
                            </div>
                        </div>
                        <label for="modal1"  style="width: 60px;height: 22px;padding-top: 10px;"><img src="../../web/images/gymPhotos/photo2.jpg" style="margin-top:-20px;width: 190px;height: 140px;border-radius: 10px;" alt="Our offices"></label>
                    </div>

                    <div class="flex-item" style="margin-left: 110px;">
                        <input class="modal__check" type="checkbox" id="modal2"/>
                        <div class="modal">
                            <label class="modal__closetwo" for="modal2"></label>
                            <div class="flex-container">
                                <div class="flex-item">
                                    <a href="##" onclick="setPreviousPicture(1)"><img src="../../web/images/gymPhotos/previousPicture.jpg" style="width: 80px; height: 80px;margin-top: -30px;"/></a>
                                </div>
                                <div class="flex-item" style="width: 900px;height: 550px;margin-top: -250px;">
                                    <div class="modal__info" style="height: 500px;">
                                        <label class="modal__close" for="modal2" id="closeLabel2" style="color: white">&times;</label>
                                        <img src="../../web/images/gymPhotos/photo3.jpg" style="margin-top:-20px;width: 900px;height: 550px;border-radius: 10px;margin-left: -20px;" alt="Our offices">
                                    </div>
                                </div>
                                <div class="flex-item" style="margin-left: -270px;">
                                    <a href="##" onclick="setNextPicture(3)"><img src="../../web/images/gymPhotos/nextPictures.jpg" style="width: 80px; height: 80px;margin-top: -30px;"/></a>
                                </div>
                            </div>
                        </div>
                        <label for="modal2"  style="width: 60px;height: 22px;padding-top: 10px;"><img src="../../web/images/gymPhotos/photo3.jpg" style="margin-top:-20px;width: 190px;height: 140px;border-radius: 10px;" alt="Our offices"></label>
                    </div>

                    <div class="flex-item">
                        <input class="modal__check" type="checkbox" id="modal3"/>
                        <div class="modal">
                            <label class="modal__closetwo" for="modal3"></label>
                            <div class="flex-container">
                                <div class="flex-item">
                                    <a href="##" onclick="setPreviousPicture(2)"><img src="../../web/images/gymPhotos/previousPicture.jpg" style="width: 80px; height: 80px;margin-top: -30px;"/></a>
                                </div>
                                <div class="flex-item" style="width: 900px;height: 550px;margin-top: -250px;">
                                    <div class="modal__info" style="height: 500px;">
                                        <label class="modal__close" for="modal3" id="closeLabel3" style="color: white">&times;</label>
                                        <img src="../../web/images/gymPhotos/photo4.jpg" style="margin-top:-20px;width: 900px;height: 550px;border-radius: 10px;margin-left: -20px;" alt="Our offices">
                                    </div>
                                </div>
                                <div class="flex-item" style="margin-left: -270px;">
                                    <a href="##" onclick="setNextPicture(4)"><img src="../../web/images/gymPhotos/nextPictures.jpg" style="width: 80px; height: 80px;margin-top: -30px;"/></a>
                                </div>
                            </div>
                        </div>
                        <label for="modal3"  style="width: 60px;height: 22px;padding-top: 10px;"><img src="../../web/images/gymPhotos/photo4.jpg" style="margin-top:-20px;width: 190px;height: 140px;border-radius: 10px;" alt="Our offices"></label>
                    </div>

                    <div class="flex-item" style="margin-left: 110px;">
                        <input class="modal__check" type="checkbox" id="modal4"/>
                        <div class="modal">
                            <label class="modal__closetwo" for="modal4"></label>
                            <div class="flex-container">
                                <div class="flex-item">
                                    <a href="##" onclick="setPreviousPicture(3)"><img src="../../web/images/gymPhotos/previousPicture.jpg" style="width: 80px; height: 80px;margin-top: -30px;"/></a>
                                </div>
                                <div class="flex-item" style="width: 900px;height: 550px;margin-top: -250px;">
                                    <div class="modal__info" style="height: 500px;">
                                        <label class="modal__close" for="modal4" id="closeLabel4" style="color: white">&times;</label>
                                        <img src="../../web/images/gymPhotos/photo5.jpg" style="margin-top:-20px;width: 900px;height: 550px;border-radius: 10px;margin-left: -20px;" alt="Our offices">
                                    </div>
                                </div>
                                <div class="flex-item" style="margin-left: -270px;">
                                    <a href="##" onclick="setNextPicture(5)"><img src="../../web/images/gymPhotos/nextPictures.jpg" style="width: 80px; height: 80px;margin-top: -30px;"/></a>
                                </div>
                            </div>
                        </div>
                        <label for="modal4"  style="width: 60px;height: 22px;padding-top: 10px;"><img src="../../web/images/gymPhotos/photo5.jpg" style="margin-top:-20px;width: 190px;height: 140px;border-radius: 10px;" alt="Our offices"></label>
                    </div>

                    <div class="flex-item" style="margin-left: 110px;">
                        <input class="modal__check" type="checkbox" id="modal5"/>
                        <div class="modal">
                            <label class="modal__closetwo" for="modal5"></label>
                            <div class="flex-container">
                                <div class="flex-item">
                                    <a href="##" onclick="setPreviousPicture(4)"><img src="../../web/images/gymPhotos/previousPicture.jpg" style="width: 80px; height: 80px;margin-top: -30px;"/></a>
                                </div>
                                <div class="flex-item" style="width: 900px;height: 550px;margin-top: -250px;">
                                    <div class="modal__info" style="height: 500px;">
                                        <label class="modal__close" for="modal5" id="closeLabel5" style="color: white">&times;</label>
                                        <img src="../../web/images/gymPhotos/photo6.jpg" style="margin-top:-20px;width: 900px;height: 550px;border-radius: 10px;margin-left: -20px;" alt="Our offices">
                                    </div>
                                </div>
                                <div class="flex-item" style="margin-left: -270px;">
                                    <a href="##" onclick="setNextPicture(6)"><img src="../../web/images/gymPhotos/nextPictures.jpg" style="width: 80px; height: 80px;margin-top: -30px;"/></a>
                                </div>
                            </div>
                        </div>
                        <label for="modal5"  style="width: 60px;height: 22px;padding-top: 10px;"><img src="../../web/images/gymPhotos/photo6.jpg" style="margin-top:-20px;width: 190px;height: 140px;border-radius: 10px;" alt="Our offices"></label>
                    </div>

                    <div class="flex-item">
                        <input class="modal__check" type="checkbox" id="modal6"/>
                        <div class="modal">
                            <label class="modal__closetwo" for="modal6"></label>
                            <div class="flex-container">
                                <div class="flex-item">
                                    <a href="##" onclick="setPreviousPicture(5)"><img src="../../web/images/gymPhotos/previousPicture.jpg" style="width: 80px; height: 80px;margin-top: -30px;"/></a>
                                </div>
                                <div class="flex-item" style="width: 900px;height: 550px;margin-top: -250px;">
                                    <div class="modal__info" style="height: 500px;">
                                        <label class="modal__close" for="modal6" id="closeLabel6" style="color: white">&times;</label>
                                        <img src="../../web/images/gymPhotos/photo7.jpg" style="margin-top:-20px;width: 900px;height: 550px;border-radius: 10px;margin-left: -20px;" alt="Our offices">
                                    </div>
                                </div>
                                <div class="flex-item" style="margin-left: -270px;">
                                    <a href="##" onclick="setNextPicture(7)"><img src="../../web/images/gymPhotos/nextPictures.jpg" style="width: 80px; height: 80px;margin-top: -30px;"/></a>
                                </div>
                            </div>
                        </div>
                        <label for="modal6"  style="width: 60px;height: 22px;padding-top: 10px;"><img src="../../web/images/gymPhotos/photo7.jpg" style="margin-top:-20px;width: 190px;height: 140px;border-radius: 10px;" alt="Our offices"></label>
                    </div>

                    <div class="flex-item" style="margin-left: 110px;">
                        <input class="modal__check" type="checkbox" id="modal7"/>
                        <div class="modal">
                            <label class="modal__closetwo" for="modal7"></label>
                            <div class="flex-container">
                                <div class="flex-item">
                                    <a href="##" onclick="setPreviousPicture(6)"><img src="../../web/images/gymPhotos/previousPicture.jpg" style="width: 80px; height: 80px;margin-top: -30px;"/></a>
                                </div>
                                <div class="flex-item" style="width: 900px;height: 550px;margin-top: -250px;">
                                    <div class="modal__info" style="height: 500px;">
                                        <label class="modal__close" for="modal7" id="closeLabel7" style="color: white">&times;</label>
                                        <img src="../../web/images/gymPhotos/photo8.jpg" style="margin-top:-20px;width: 900px;height: 550px;border-radius: 10px;margin-left: -20px;" alt="Our offices">
                                    </div>
                                </div>
                                <div class="flex-item" style="margin-left: -270px;">
                                    <a href="##" onclick="setNextPicture(8)"><img src="../../web/images/gymPhotos/nextPictures.jpg" style="width: 80px; height: 80px;margin-top: -30px;"/></a>
                                </div>
                            </div>
                        </div>
                        <label for="modal7"  style="width: 60px;height: 22px;padding-top: 10px;"><img src="../../web/images/gymPhotos/photo8.jpg" style="margin-top:-20px;width: 190px;height: 140px;border-radius: 10px;" alt="Our offices"></label>
                    </div>

                    <div class="flex-item" style="margin-left: 110px;">
                        <input class="modal__check" type="checkbox" id="modal8"/>
                        <div class="modal">
                            <label class="modal__closetwo" for="modal8"></label>
                            <div class="flex-container">
                                <div class="flex-item">
                                    <a href="##" onclick="setPreviousPicture(7)"><img src="../../web/images/gymPhotos/previousPicture.jpg" style="width: 80px; height: 80px;margin-top: -30px;"/></a>
                                </div>
                                <div class="flex-item" style="width: 900px;height: 550px;margin-top: -250px;">
                                    <div class="modal__info" style="height: 500px;">
                                        <label class="modal__close" for="modal8" id="closeLabel8" style="color: white">&times;</label>
                                        <img src="../../web/images/gymPhotos/photo9.jpg" style="margin-top:-20px;width: 900px;height: 550px;border-radius: 10px;margin-left: -20px;" alt="Our offices">
                                    </div>
                                </div>
                                <div class="flex-item" style="margin-left: -270px;">
                                    <a href="##" onclick="setNextPicture(0)"><img src="../../web/images/gymPhotos/nextPictures.jpg" style="width: 80px; height: 80px;margin-top: -30px;"/></a>
                                </div>
                            </div>
                        </div>
                        <label for="modal8"  style="width: 60px;height: 22px;padding-top: 10px;"><img src="../../web/images/gymPhotos/photo9.jpg" style="margin-top:-20px;width: 190px;height: 140px;border-radius: 10px;" alt="Our offices"></label>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
</body>
</html>
