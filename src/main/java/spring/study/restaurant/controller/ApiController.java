package spring.study.restaurant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.study.restaurant.wishlist.dto.WishListDto;
import spring.study.restaurant.wishlist.service.WishListService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurant")
public class ApiController {

    private final WishListService wishListService;

    @GetMapping("/search")
    public WishListDto search(@RequestParam String query) {
        return wishListService.search(query);
    }

    @PostMapping("")
    public WishListDto add(@RequestBody WishListDto request) {
        return wishListService.add(request);
    }

    @GetMapping("/all")
    public List<WishListDto> findAll() {
        return wishListService.findAll();
    }

    @DeleteMapping("/{index}")
    public void delete(@PathVariable int index) {
        wishListService.delete(index);
    }

    @PutMapping("/{index}")
    public void addVisit(@PathVariable int index) {
        wishListService.addVisit(index);
    }
}
