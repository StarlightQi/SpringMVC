<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021-04-09
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
    <script src="js/jquery-3.6.0.min.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<div class="panel panel-default" style="width: 60%;margin: auto">
    <div class="panel-body">
        <div class="alert alert-info" role="alert">用户个人信息修改</div>
        <form action="updateUserInfo" method="post"
              enctype="multipart/form-data">
            <div class="form-group">
                <label> 用户头像:</label>
                <div class="row">
                    <div class="col-xs-6 col-md-3">
                        <a href="#" class="thumbnail">
                            <img src="image/${user.file}" width="200" height="200" alt="用户头像">
                        </a>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="email">邮箱地址：</label>
                <input type="email" class="form-control" id="email" placeholder="Email" value="${user.email}">
            </div>
            <div class="form-group">
                <label for="userName">用户名称：</label>
                <input type="text" class="form-control" id="userName" placeholder="name" value="${user.userName}">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">密码：</label>
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"
                       value="*****">
            </div>
            <div class="form-group">
                <label>实名认证：</label>

                <div class="card">
                    <h5 class="card-header">上传身份证正面 <img src="image/${user.zhen}" width="20" height="20"></h5>
                    <div class="card-body">
                        <div class="custom-file">
                            <input type="file" name="files" class="custom-file-input" value="" id="zhen" lang="zh">
                            <label class="custom-file-label" for="zhen">上传身份证正面</label>
                        </div>
                    </div>
                </div>


                <div class="card">
                    <h5 class="card-header">上传身份反面 <img src="image/${user.zhen}" width="20" height="20"></h5>
                    <div class="card-body">
                        <div class="custom-file" style="margin-top: 30px">
                            <input type="file" name="files" class="custom-file-input" id="fan" lang="zh">
                            <label class="custom-file-label" for="fan">上传身份反面</label>
                        </div>
                    </div>
                </div>

            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>
</div>

<script src="js/bs-custom-file-input.min.js"></script>
<script>
    bsCustomFileInput.init();

</script>
</body>
</html>
