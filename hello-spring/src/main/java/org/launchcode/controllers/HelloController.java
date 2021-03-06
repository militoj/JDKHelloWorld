package org.launchcode.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.RequestWrapper;

/**
 * Created by johnmilito on 3/6/17.
 */

@Controller
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody

    public String index(HttpServletRequest request) {

        String name = request.getParameter("name");

        if (name == null) {
            name = "World";
        }

        return "Hello " + name;
    }


    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm() {
        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<select name='language'>" +
                "   <option value='English' selected>English</option>" +
                "   <option value='Spanish' >Spanish</option>" +
                "   <option value='French' >French</option>" +
                "   <option value='Japanese' >Japanese</option>" +
                "   <option value='Italian' >Italian</option>" +
                "</select>" +
                "<input type='submit' value='Greet Me!' />" +
                "</form>";

        return html;

    }


    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request) {
        String name = request.getParameter("name");
        String language = request.getParameter("language");

        return createMessage(name, language);
    }

    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "goodbye")

    public String goodbye() {
        return "redirect:/";
    }

    public String createMessage(String name, String language) {
        if (language.equals("English")) {
            return "Hello " + name;
        } else if (language.equals("Spanish")) {
            return "Hola " + name;

        } else if (language.equals("French")) {
            return "Bonjour " + name;

        } else if (language.equals("Japanese")) {
            return "こんにちは " + name;

        } else {
            return "Ciao " + name;

        }

    }
}
