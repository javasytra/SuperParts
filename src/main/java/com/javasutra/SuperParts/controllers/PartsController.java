package com.javasutra.SuperParts.controllers;

import com.javasutra.SuperParts.models.Part;
import com.javasutra.SuperParts.services.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PartsController {

    @Autowired
    private PartService partService;

    private String selectparts = null;
    private String titleFilter = "";

    @GetMapping("/")
    public String homeAction(
            @RequestParam(value="name", required=false) String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

    @RequestMapping(value="/parts", method=RequestMethod.GET)
    public String getParts(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                           @RequestParam(required = false, defaultValue = "id") String sortBy,
                           @RequestParam(required = false, defaultValue = "ask") String order, Model model) {
        Sort sort;
        if (order.equals("desc")) sort = new Sort(Sort.Direction.DESC, sortBy);
        else sort = new Sort(Sort.Direction.ASC, sortBy);
        Integer pageNumber = (page > 0) ? page - 1 : 0;
        PageRequest pageRequest = PageRequest .of(pageNumber, 10, sort);
        Page<Part> parts = null;
        if(selectparts!=null){
            parts = partService.search(titleFilter, selectparts, pageRequest);
        }
        else {
            parts = partService.search(titleFilter, pageRequest);
        }
        model.addAttribute("parts",parts.getContent());
        model.addAttribute("pages",parts);
        model.addAttribute("computer",partService.findAssembledComputer());
        model.addAttribute("correctText",partService.correctText(partService.findAssembledComputer()));
        return "MainPage";
    }

    @PostMapping("/parts")
    public String delete(@RequestParam(value="id") long id) {
        partService.delete(partService.findById(id));
        return "redirect:/parts";
    }

    @PostMapping("filter")
    public String filter(@RequestParam(value="title") String title) {
        if (!title.equals("")) {
            titleFilter = title;
        } else titleFilter = "";
        return "redirect:/parts";
    }

    @GetMapping("/selectAll")
    public String selectAll() {
        selectparts = null;
        return "redirect:/parts";
    }

    @GetMapping("/selectNeed")
    public String selectNeed() {
        selectparts = "1";
        return "redirect:/parts";
    }

    @GetMapping("/selectOptional")
    public String selectOptional() {
        selectparts = "0";
        return "redirect:/parts";
    }

    @RequestMapping(value = "/addNewPart", method=RequestMethod.GET)
    public String addNewPartPage(Model model) {
        model.addAttribute("part",new Part());
        return "addNewPart";
    }

    @PostMapping("/addNewPart")
    public String addNewPart(@RequestParam(value="title") String title,
                             @RequestParam(value="partscount") int partscount,
                             @RequestParam(value="need", defaultValue = "false") boolean need,
                             Model model) {
        Part part = new Part(title,need,partscount);
        partService.save(part);
        return "redirect:/parts";
    }

    @GetMapping("/editPart/{id}")
    public String edit(@RequestParam(value="id") long id , Model model) {
        Part editPart = partService.findById(id);
        model.addAttribute("part",editPart);
        return "editPart";
    }

    @PostMapping("/editPart/{id}")
    public String updetePart(@RequestParam(value="id") long id,
                             @RequestParam(value="title") String title,
                             @RequestParam(value="partscount") int partscount,
                             @RequestParam(value="need", defaultValue = "false") boolean need) {
        Part part = new Part(title,need,partscount);
        partService.update(part,id);
        return "redirect:/parts";
    }
}
