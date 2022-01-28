package com.example.openaccessbackend.service;

import com.example.todoapp.exception.InformationExistException;
import com.example.todoapp.exception.InformationNotFoundException;
import com.example.todoapp.model.Category;
import com.example.todoapp.model.Item;
import com.example.todoapp.repository.CategoryRepository;
import com.example.todoapp.repository.ItemRepository;
import com.example.todoapp.security.MyUserDetails;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private AnswerRepository answerepository;
    private QuestionRepository questionRepository;
    private static final Logger LOGGER = Logger.getLogger(CategoryService.class.getName());

    public AnswerService() {
    }

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Category> getCategories() {
        LOGGER.info("calling getCategories method from service");
        MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(userDetails.getUser().getId());
        List<Category> categories = this.categoryRepository.findByUserId(userDetails.getUser().getId());
        if (categories.isEmpty()) {
            throw new InformationNotFoundException("no categories found for user id " + userDetails.getUser().getId());
        } else {
            return categories;
        }
    }

    public Category getCategory(Long categoryId) {
        LOGGER.info("calling getCategory method from service");
        MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Category category = this.categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
        if (category == null) {
            throw new InformationNotFoundException("category with id " + categoryId + " not found");
        } else {
            return category;
        }
    }

    public Category createCategory(Category categoryObject) {
        LOGGER.info("calling createCategory method from service");
        MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Category category = this.categoryRepository.findByUserIdAndName(userDetails.getUser().getId(), categoryObject.getName());
        if (category != null) {
            throw new InformationExistException("category with name " + category.getName() + " already exists");
        } else {
            categoryObject.setUser(userDetails.getUser());
            return (Category)this.categoryRepository.save(categoryObject);
        }
    }

    public Category updateCategory(Long categoryId, Category categoryObject) {
        LOGGER.info("calling updateCategory method from service");
        MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Category category = this.categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
        if (category == null) {
            throw new InformationNotFoundException("category with id " + categoryId + " not found");
        } else {
            category.setName(categoryObject.getName());
            category.setDescription(categoryObject.getDescription());
            return (Category)this.categoryRepository.save(category);
        }
    }

    public String deleteCategory(Long categoryId) {
        LOGGER.info("calling deleteCategory method from service");
        MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Category category = this.categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
        if (category == null) {
            throw new InformationNotFoundException("category with id " + categoryId + " not found");
        } else {
            this.categoryRepository.deleteById(categoryId);
            return "category with id " + categoryId + " has been successfully deleted";
        }
    }

    public Item createCatItem(Long categoryId, Item itemObject) {
        LOGGER.info("calling createCatItem method from service");
        MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Category category = this.categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
        if (category == null) {
            throw new InformationNotFoundException("category with id " + categoryId + " not found");
        } else {
            Item item = this.itemRepository.findByUserIdAndName(userDetails.getUser().getId(), itemObject.getName());
            if (item != null) {
                throw new InformationExistException("item with name " + itemObject.getName() + " already exists");
            } else {
                itemObject.setUser(userDetails.getUser());
                itemObject.setCategory(category);
                return (Item)this.itemRepository.save(itemObject);
            }
        }
    }

    public List<Item> getCatItems(Long categoryId) {
        LOGGER.info("calling getCatItems method from service");
        MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Category category = this.categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
        if (category == null) {
            throw new InformationNotFoundException("category with id " + categoryId + " not found");
        } else {
            return category.getItemList();
        }
    }

    public Item getCatItem(Long categoryId, Long itemId) {
        LOGGER.info("calling getCatItem method from service");
        MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Category category = this.categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
        if (category == null) {
            throw new InformationNotFoundException("category with id " + categoryId + " not found");
        } else {
            Optional<Item> item = this.itemRepository.findByCategoryId(categoryId).stream().filter((i) -> {
                return i.getId().equals(itemId);
            }).findFirst();
            if (!item.isPresent()) {
                throw new InformationNotFoundException("item with id " + itemId + " does not exist");
            } else {
                return (Item)item.get();
            }
        }
    }

    public Item updateCatItem(Long categoryId, Long itemId, Item itemObject) {
        LOGGER.info("calling updateCatItem method from service");
        MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Category category = this.categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
        if (category == null) {
            throw new InformationNotFoundException("category with id " + categoryId + " does not exist");
        } else {
            Optional<Item> item = this.itemRepository.findByCategoryId(categoryId).stream().filter((i) -> {
                return i.getId().equals(itemId);
            }).findFirst();
            if (!item.isPresent()) {
                throw new InformationNotFoundException("item with id " + itemId + " does not exist");
            } else {
                Item item1 = this.itemRepository.findByUserIdAndNameAndIdIsNot(userDetails.getUser().getId(), itemObject.getName(), itemId);
                if (item1 != null) {
                    throw new InformationExistException("item with id " + itemId + " already exists");
                } else {
                    ((Item)item.get()).setName(itemObject.getName());
                    ((Item)item.get()).setDescription(itemObject.getDescription());
                    ((Item)item.get()).setDueDate(itemObject.getDueDate());
                    return (Item)this.itemRepository.save((Item)item.get());
                }
            }
        }
    }

    public Optional<Item> deleteCatItem(Long categoryId, Long itemId) {
        LOGGER.info("calling deleteCatItem method from service");
        MyUserDetails userDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Category category = this.categoryRepository.findByIdAndUserId(categoryId, userDetails.getUser().getId());
        if (category == null) {
            throw new InformationNotFoundException("category with id " + categoryId + " does not exist");
        } else {
            Optional<Item> item = this.itemRepository.findByCategoryId(categoryId).stream().filter((i) -> {
                return i.getId().equals(itemId);
            }).findFirst();
            if (!item.isPresent()) {
                throw new InformationExistException("item with id " + itemId + " does not exist");
            } else {
                this.itemRepository.deleteById(((Item)item.get()).getId());
                return item;
            }
        }
    }
}
