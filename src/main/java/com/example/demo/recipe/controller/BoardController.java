package com.example.demo.recipe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.recipe.domain.Recipe;
import com.example.demo.recipe.service.RecipeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
    
    @Autowired
    RecipeService recipeService;
    
    private Recipe recipe;
    
    //setter 주입
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
    
    //  레시피 목록 보기
    @RequestMapping(value="/board/list/{user_seq}", method = RequestMethod.GET)
    public String list(Model model, Recipe recipe, Integer user_seq) throws Exception{
        //model.addAttribute("user_seq",recipeService.getRecipeList(user_seq));
        
        //model.addAttribute("recipe_seq",user_seq);
        
        List<Recipe> list = recipeService.getRecipeList2(recipe);
        model.addAttribute("list", list);
        
        model.addAttribute("user_seq", user_seq);
        
        return "/board/list";
        
    }
    
    //  레시피 상세 보기
    @RequestMapping(value="/board/detail/{user_seq}/{recipe_seq}", method = RequestMethod.GET)
    public String detail(Model model, Recipe recipe) throws Exception{
        
        List<Recipe> list = recipeService.getRecipeDt2(recipe);
        model.addAttribute("list", list);
        
        int recipe_seq = recipe.getRecipe_seq();
        model.addAttribute("recipe_seq", recipe_seq);
        System.out.println("레시피 번호는 "+ recipe_seq);
        
        Integer user_seq = recipe.getUser_seq();
        model.addAttribute("user_seq", user_seq);
        System.out.println("유저 번호는 "+ user_seq);
        
        return "/board/detail";
    }
    
    //  레시피 수정 페이지
    @RequestMapping(value="/board/modify/{recipe_seq}")
    public String modify(Model model, Recipe recipe) throws Exception{

        int recipe_seq = recipe.getRecipe_seq();
        model.addAttribute("recipe_seq", recipe_seq);
        System.out.println("레시피 번호는 "+ recipe_seq);
        
//        Integer user_seq = recipe.getUser_seq();
//        model.addAttribute("user_seq", user_seq);
//        System.out.println("유저 번호는 "+ user_seq);
        return "/board/modify";
    }
    
    //  레시피 수정 기능
    @RequestMapping(value="/board/modify", method=RequestMethod.POST)
    public String modify(Recipe recipe) throws Exception{
        recipeService.updateRecipe(recipe);
        
        return "redirect:/board/list";
    }
    
    //  레시피 삭제
    
    //  요리법 상세 작성
    
    //  요리법 삭제(DB에서 데이터 삭제)
}
