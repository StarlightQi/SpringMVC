<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring MVC</title>
    <link rel="stylesheet" href="css/index.css">
    <script src="js/jquery-3.5.1.min.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bs-custom-file-input.js"></script>
</head>
<body>

<div class="all">
    <div class="top"><img src="img/logo.png"></div>

    <div class="main">
        <div class="zhuce">
            <div>注册新用户
                <div style=" float: right">已有账号,去<a href="index.jsp">登录</a></div>
            </div>
            <div class="login" style="margin: 10px 0 auto 10% ; width:700px;float: left;">
                <form style="margin-top: 100px" action="login" method="post" enctype="multipart/form-data" >
                    <div class="form-group row">
                        <div class="custom-file">
                            <input type="file" class="custom-file-input" name="attach" id="imgInp">
                            <label class="custom-file-label" for="imgInp"
                                   style="width: 79%;margin-left: 136px;">上传头像</label>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="staticEmail" class="col-sm-2 col-form-label">手机号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="number" id="staticEmail" value="12345678901">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="yzm" class="col-sm-2 col-form-label">短信验证码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="yzm" id="yzm" value="123">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputPassword" class="col-sm-2 col-form-label">密码</label>
                        <div class="col-sm-10">
                            <input type="password" name="pwd" class="form-control" id="inputPassword">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="Password" class="col-sm-2 col-form-label">验证密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control " name="psw" id="Password">
                        </div>
                    </div>
                    <div class="panel-body">
                        <div style="width: 90%;border-bottom: rgba(99,99,99,0.98) dashed; margin:30px"></div>
                        实名认证
                        <div class="form-group row">
                            <div class="custom-file">
                                <input type="file" class="custom-file-input" id="zhen" name="attachs">
                                <label class="custom-file-label" for="zhen" style="width: 79%;margin-left: 136px;" >身份证正面</label>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="custom-file">
                                <input type="file" class="custom-file-input" id="fan" name="attachs">
                                <label class="custom-file-label" for="fan" style="width: 79%;margin-left: 136px;">身份反面</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-12">
                            <input style="margin-left: 50%;width: 200px" type="submit" class="btn btn-primary" value="提交个人信息">
                        </div>
                    </div>

                </form>
                <%--
                                <form action="login" method="post" enctype="multipart/form-data">
                                    <ul>
                                        <li><label>手机号：</label><input type="text" value="18978818420" name="number"><span id="num"
                                                                                                                          style="display: none"><img
                                                src="img/error.png"><span style="width: 250px;
                            height: 50px;">手机号格式不正确，请重新输入</span></span></li>
                                        <li><label>短信验证码：</label><input type="text" name="yzm"></li>
                                        <li><label>密码：</label><input type="password" name="pwd"><span style="display: none"
                                                                                                      id="show1"><img
                                                src="img/success.png">请输入密码</span></li>
                                        <li><label>确认密码：</label><input type="password" name="psw"><span style="display: none"
                                                                                                        id="show2"><img
                                                src="img/success.png">请确认密码</span></li>
                                        <li style="margin-left:10px">
                                            <input type="file" name="attach" id="imgInp"></li>

                                        <h4>上传身份验证信息：</h4>
                                        身份证正面：<input type="file" name="attachs"/> <br/>
                                        身份证反面：<input type="file" name="attachs"/> <br/>
                                    </ul>
                                    <br>
                                    <input type="submit" name="attach" value="完成注册"
                                           style="width: 150px;height: 40px;margin-left: 100px;background-color:firebrick;color: white">
                                </form>

                --%>
            </div>

            <div style="float: right;margin-right: 32%;margin-top: 30px;">
                <image id="blah" style="width:150px; height:200px;margin-top: 80px"/>
            </div>

        </div>
    </div>
    <div class="bottom" style="text-align:center">
        <p>关于我们 | 联系我们 | 联系客服 | 商家入驻 | 营销中心 | 手机 | 友情链接 | 销售联盟 | 社区 | 公益 | English Site | Contact U</p>
        <p>地址：广西壮族自治区南宁市邕宁区龙亭路8号南宁学院 邮编：530200电话：400-000-4000 传真：000-11111100 邮箱: 2324239742@qq.com <br></p>
    </div>
</div>
<script>
    bsCustomFileInput.init();

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                document.getElementById('blah').src = e.target.result;
            }
            reader.readAsDataURL(input.files[0]);
        }
    }

    document.getElementById("imgInp").onchange = function () {
        readURL(this);
    }

</script>
</body>
</html>