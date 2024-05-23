package com.iset.sante.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iset.sante.entities.Message;
import com.iset.sante.service.ChatService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatController {
	 @Autowired
	    private ChatService chatService;

    private List<String> messages = new ArrayList<>();

    @GetMapping("/user_chat")
    public String userChat(Model model, Principal principal) {
        model.addAttribute("messages", messages);
        return "user_chat";
    }

    @GetMapping("/admin_chat")
    public String adminChat(Model model) {
        model.addAttribute("messages", messages);
        return "admin_chat";
    }

    @PostMapping("/user_to_admin/send")
    public String userToAdminSend(String message, Principal principal) {
        String username = principal.getName();
        messages.add(username + ": " + message);
        return "redirect:/user_chat";
    }

    @PostMapping("/admin_to_user/send")
    public String adminToUserSend(String message) {
        messages.add("Admin: " + message);
        return "redirect:/admin_chat";
    }
    @PostMapping("/admin/edit")
    public String editMessageByAdmin(@RequestParam("id") Long id, @RequestParam("newText") String newText) {
        chatService.editMessageByAdmin(id, newText);
        return "redirect:/admin_chat";
    }

    @PostMapping("/admin/delete")
    public String deleteMessageByAdmin(@RequestParam("id") Long id) {
        chatService.deleteMessageByAdmin(id);
        return "redirect:/admin_chat";
    }

    @PostMapping("/user/edit")
    public String editMessage(@RequestParam("id") Long id, @RequestParam("newText") String newText) {
        chatService.updateMessage(id, newText);
        return "redirect:/user_chat";
    }

    @PostMapping("/user/delete")
    public String deleteMessage(@RequestParam("id") Long id) {
        chatService.deleteMessage(id);
        return "redirect:/user_chat";
    }

}
