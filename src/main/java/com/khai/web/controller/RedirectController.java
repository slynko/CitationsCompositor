package com.khai.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController
{
  @GetMapping("/edit")
  public String redirectFromEdit() {
    return "redirect:/";
  }

  @GetMapping("/view")
  public String redirectFromView() {
    return "redirect:/";
  }
}
