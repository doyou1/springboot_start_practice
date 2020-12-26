package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    // 생성자를 통한 주입이 현시점에선 가장 적절한 방법
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 필드에 Autowired 주입 가능
//    @Autowired private final MemberService memberService;

    // setMethod로 주입 가능, 아무때나 부를 수 있으므로 사용 X
//    @Autowired
//    public void setMemberService(MemberService memberService){
//            this.memberService = memberService;
//    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberList";
    }

}
