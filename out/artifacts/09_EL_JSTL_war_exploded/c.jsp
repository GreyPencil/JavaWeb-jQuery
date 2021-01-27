<%@ page import="java.util.List" %>
<%--<%@ page import="" %>--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.suze.pojo.Person" %><%--
  Created by IntelliJ IDEA.
  User: beark
  Date: 1/8/2021
  Time: 7:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Person person = new Person();
        person.setName("星爷");
        person.setPhones(new String[]{"13313211320","18688886666"});
        List<String> cities = new ArrayList<String>();
        cities.add("北京");
        cities.add("上海");
//        cities.add("天津");

        person.setCities(cities);

        Map<String, Object> map = new HashMap<>();
        map.put("keyq","value1");
        map.put("key2", "value2");

        person.setMap(map);

        pageContext.setAttribute("person",person);


    %>

    输出Person：${ person }<br/>
    输出Person.name：${ person.name }<br/>
    输出Person.phone：${ person.phones }<br/>
</body>
</html>
