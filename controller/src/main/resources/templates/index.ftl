<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
<div>
    <@ArticleList count=4 tip='true'; list, map >
        <#list list as item>
            <li>${item}</li>
        </#list>
    </@ArticleList>
</div>
</body>
</html>