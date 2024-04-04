package com.example.homework37

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework37.databinding.FragmentRecyclerBinding

class RecyclerFragment : Fragment() {

    private var _binding: FragmentRecyclerBinding? = null
    private val binding get() = _binding!!
    private var celebritiesAdapter: CelebritiesAdapter? = null
    private val celebrities = mutableListOf<CelebritiesModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecyclerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addCinemas()
        setupRecyclerView()
    }

    private fun addCinemas() {
        addCelebrity(
            "Billie Eilish",
            "https://www.usmagazine.com/wp-content/uploads/2023/03/Billie-Eilish-more-celebrities-who-took-social-media-breaks-social.jpg?quality=86&strip=all"
        )
        addCelebrity(
            "Michael Jordan",
            image = "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxMSEhUTExMVFRUXFxgbFhgVGRcYGRcWFxgdGBgYFhcYHSggGBslGxgbITEiJSkrLi4uHSAzODMtNygtLisBCgoKDg0OGxAQGy0lICYtLy0tKy0tLS4tLS0rLS0tLS0tLS0tLy0rLS0vLS0tLS0tLS0tLS0tLS0tLS0tLS0tLf/AABEIAMABBwMBIgACEQEDEQH/xAAcAAEAAgMBAQEAAAAAAAAAAAAABAUDBgcCCAH/xABGEAABAwIDBAcEBwcCBAcAAAABAAIDBBESITEFQVFhBgcTInGB8DKRocEUUmJygrHhIzNCQ1OS0WOiJERU8QgVg6OzwsP/xAAaAQEAAwEBAQAAAAAAAAAAAAAAAwQFAgEG/8QAOBEAAgIBAwICBgYKAwAAAAAAAAECEQMEITESQWGBMlGRobHBExQiI1JxM0JigpKistHh8AUVJP/aAAwDAQACEQMRAD8A7iiIgCIiAIiIAiIgCIiAIiIAiL8JQH6i1DbfWLRQXDH9u8aiIgsB+1Ie6PAXPJc5251sVMhIiLYRwjAJ83vGfkGqKWaMduSWOGUjuqL5sh6aVgdiFTPfnK8j3E2+C2zYfWpUMsJw2ZvE2Y/yc0WPmPNRrUxvdNEj0sq2Ozota2H05o6ohgk7OQ6Ry90k8Gn2XnkCTyWyqxGSkrRXcXF0wiIvTwIiIAiIgCIiAIiIAiIgCIiAIiIAiIgCIiAIiIAiIgCIiAxVVQyNjpHuDWMaXOc42DWtFySdwAXzz0+6yJK95jjLo6QGwYMnTfal5cGacbnTcevzpH2cMdEx1nS9+W2vZNPcaeTni/4CN64O+S6im+x3HbcnTVrnZXyGgG5eYRc5lRYCpsTc1A1XBYx3J2yfBFdSY6d27NeqCG9vX6q2bScfz09c1UlJmikkVrcxhcLg5WOa6B1f9PZIJGU1U8vgcQ1kjz3oifZDnH2o91z7PhpqUkQG73rBNDibp63pjzOEtiPLiU0fTKLVOrLaxqKFmM3kiJieTqcPsE8SWFufG62ta0XasyJKnQREXp4EREAREQBERAEREAREQBERAEREAREQBERAEREARF+OdYEncgPlvrW2r9I2nUuvdrH9m3kIu4bfiDj5rTipW0agySPkP8bnO/uJd81FUHidy5oz0wVxRsz0VbSMur6igNhayr5ZF7TR2s2TZtN7Izz19DerwUOlreuVgq/ZMuFovbLPhoLK6FfloALm9t+5Vo0Szuyg2nTi/wCqrmm3rmtgrJMX6qhfa5UUkSwZvHU/WYaieHc9gePvMdY+ZD/9q6uuG9XspZtGDgS5p8DG7L32XclqaSV4zN1UayBERWSsEREAREQBERAEREAREQBERAEREAREQBERAEREAULbFSyOF5kkZGCC0Oe4NGJws0XcbXJU1cX/APEZtDu0lMM7mSV34QGMy/G9eN0j1HFZBkPBY2kb1lmdn4gfksbAN6hXB0+S02ZIy4uVulDTNcBhPq60Wj2c6U/sBI8i17MJtdriNM9GO3blm2dtZ8LgCTlzuq2XC5bou4c/SumXtOl0VHnbFkPzte35KybBG03e8Aa3JAAWr0NTI+Myt9n58lRbWr3POF2I3yAAJPgqsI26LMuLN52hU0w9mUOduDc7ny3Kils7MZOtfxGuo195Vf0brKJrS6SKT+IB5aC3E0BzhrYWBBz3KyNTG912W8vlyTNHp7M8xS6u5Z9D3AVtO4kNDX3JOQADSSSToLArusMrXtDmuDmkXBaQQRxBGq+d46fHlqBmfAG67B1YVIfs+PKxa6RpHA4ySPK9lZ0WTmHmV9ZDbr8ja0RFomeEREAREQBERAEREAREQBERAEREAREQBERAEREAXzd181/abULB/JhiYfE3lv7pB7l9Ir536/djmLaDaj+GojB/9SGzHD+0x/Fcy4PUczfoPBZIoTcHVY9wVjSNGFQSlSJsUOuRedGak00vbtawPDXAOIBwgjvFofcA23248StZ2nKHzPcNC4kabzmbDIXOanVElhmqqJpc7Liucd7tkmoSTUUdQ6Msc6jdGBmCHfIrxV0kjg1zAMbHA+yDpvJti36aLN0beY4LcQL+RVtsufDKL7/zWWp/eGlKP2Sp6O7HLO0lY1jHyAtxRnNrTqGFxOC+8tz4Eb88Gx2RgYWgWv5+vktxds6JwuG4XctOOiqNqR4W2UuZyq7IcVcUaqync4kNJaQL5cARl4Lr3VuMNM5mVw/Flnk9o+YcuV08mIyMGrmWv9UYhcjyC6n1bUhbTveb995Db3PcjGAa8wSu9H+lX5HOrf3fmbaiItcygiIgCIiAIiIAiIgCIiAIiIAiIgCIiAIiIAiIgC13pr0Op9pxNjnL2ljsTHxkBzSRYjvAggjUW3DgtiRAfO/Wx0Fg2ZDS9hjdidKJHyEFznWYWaAAAAOsAP8AK59Sy2C+huvPZZm2YXgXMEjJMvqm8bvIB+L8K+bSVDONslhNx3R7qpSSpNNMxpbfzUd1gF5gZc5rhpNUeqbUr7nYujFdSiA9qC4/wlpGu5ZabaNPNLggZI17TmSDhAGvew2+OfmtIp6hsZp+zaG2GeEG50sTxOR8L6rY5Nslp0w3Ogy36eKzXjo1OuzavpeE65Z+iqbbW0Q64CrWbYx3bvzt7rqA5xOZXOS3sILudC6LdDmVVJFNjMbyZQ4hodjjxkAG+hBabH7RyOVuibMoGQRNiZfC3jqSTck8ySoPQ+EMoaYD+kw+bhiPxKuFr4cUYpNLekZeXJKTavawiIpiEIiIAiIgCIiAIiIAiIgCIiAIiIAiIgCIiAIipukHSikorfSZQwuBLRZzi4DWwaDxXjaXJ7GLk6SLlfjnAC5yA1uuQ7b66gLilpvB85//ADYc/wC5c/6XdN6utAZNIQ2zbsYMLA5wDgMF7usCM3Em9wLDXh5V2J/q8l6ex27pp002bBTvZPKJhK1zOyhIe54IwuGRs3XUkL5ccFK2nWdpJcZNaA1o4NGgUEvzXNtkTpbIyy5tB4Kw2LCXHLDfmPyVYCp+zI3AgtJaeSjyejRLgf3iZvtDQVDMr4r+zYvuLcOAzG9W20NkyNYHSybgbOGIi/3iTvVFsuvqrANluN3dGnBXAMhAMrnPI0xWAHgBYXWfI0212K6WDA69yMQGRPDlu1Xi1zyC9VxuR4/FZAywXMxE2nZHWU+mjZE+DHHG0Nux3fLWjUNIsTbdcLf2dLqcshmuRDPbs5TYMLiCcDrm7XWB1FsrXuuLxUwebb1dbdgw7HpGm5w1kobfc3BPYDgBoreDUSaafZEP1SOTNCPHU0vb3O0xztcS0OBI1G8cLjULIuA7dkcaTZ85e4yllQ3HiOLDHUERjFe/dDiFO6P9Y9dEBEQKm5AZ2l8dzkBjHtedzzU/1pKVSRN/0eWeFZcUk+duOG18vA7girBt2nExp3TRtmbhuxxDSS4XGG/ta6DNWasppmM4tcoIiL05CIiAIiIAiIgCIiAIiIAiIgCItB6fdY8VGHQwESVGh3siP2vrO+zu38DzKSirZ1GLk6RM6yul8mzoWOhYx73vDbvvZgLXHFhGZ9m2oXEukG1ZqmnhlmeZH9rUBzjxLgQBwAbawGQFlJpq+StpK8yOc+WN0VTicblzWnDJbhZgOQy0Cr6BofT1MW9hZUM8BaKX/aWFV5ycvYaOmglG12kk34NV8SgeVL6UNtIDxhjd7rj5BR8HePgrPpCA+Gkfxiew+MbgBfyuVzBnuoxur8WjW6ttpHDmsCn7ViP7J/142nzGTlBCmXBmSW5+tVjsuezrHS3zUENuvyNxBXjVo7g3F2dG2PU4Brkc1a120mkAA5W109XXO6SvIyJt5X+auaNwccyXeOioyg48mjFqfBeQnGcW7dp5lSGxrFCBbNS4m39fNVZSJ0j1SxZg81cdNxh2dRRnV0s0nld9j7pQolOy2dl662Z+zfTwamnpbm31pLAjx/Yj3qfB6Mn4V7SbSq9Vi8Hf8KshbdbbZ2zGH6lRJ5SShw+BUDodR9tX0zP9UO8o++ffhsrHp4wRSQ0wOVNSwxHfZwbc+ZBavPVnOG1j5Tn2cEzm+LW/4upJK81eKNrFN4v+L6u7jJ+238zzUuNZtg2/mVoHjHA4NJHjFCT5rpTun0MdRLDK1zWseWiRveGWRxNGYzvpdc66pafFtCMuz7KCWTEfrdyK9+JErvipG3IGHFJeziST4nMrqWWUI9Ue7bMLXYovMsL/AFIRj51b+J2WirY5mh8T2vad7SCPA20PJSF85bO2rNC8vge5jhvabX5EaEcit82D1pOsBUxYvtx2DvNhyPkR4KbHrIv09jMyaOS9Hc6iiqdidI6ar/cyguGrDdrx+E5kcxkrZW4yUlaKjTTphERengREQBERAEREAULa21YaZhknkaxvPUng0DNx5BU3TfplDs6O7u/K4Hs4wdftOP8AC2+/fu32+fukPSaeskMkz7k6AZNaPqtG4KHJl6dlyTY8XVu+Dd+m3WpLNiipbwx6F/8AMcPEfux4Z8xouVvkLivUt7eJU6ipe7fmq0pd5FqOO30rZFt0BkEdYzGP2cwdBJfe2YYQP78I96w7JZ2FWyKQ3tJJTS7rtfeAnl3sLvJRZJSwEs1bZzfvNIc34hTOmz7Vc8jdJBFPHzxRtdf+9rl7GVxv1P3MnxxSlKH4ov2rdFIWEON9RkfHRSo2mSkdb+TK1/4JB2ZtyBsVgqz33/ePxNx8Cvzo/UYXEOBMbmujlsD+6cLOJtph9r8KRW5PqJ3FV3389mSDTdtQyW9umkxc+yk18gST+Fa0tl2JWGCdwe0vY5r4pmtt3hmLi+Rz05OWCg2e0WsMR4nT16upXNRRmPA5z+zwV1JQSP0BVrT7CYT3n57wM/g25V1T0V/aN+Wg93+VbU1OBoLD171WlmZdhpYrle0pYNixWAwPN+GWn3iCrKCgYPZjcDywj/7q1azl68P+6zti5eSryyNluOFIrWQDi4ci0kDzA+am0kZ1FnD7Jv8AloeSlMjWQwtNiQLjR2QI8HA3HvUEmjv6ItOjNKJaiNm65e77jLE35YsLfxLW21H/AJltdr7/ALN8+O+4U9OMQJ4BzYxfm9XMMsjA8MebPa5jrWD8LhY4XacLXz0N1U0NAKWGrlDwXuiEELRcODJDinc5u6zGDPhwurODJFJR835cHmHE05/iklCP7zqT8kUW3tpGomlmN/2jy4A2uGk91uXBth5KR0FlLa2LhI4xHmJWmPPzdfyVHivor/odTf8AGQHRkbu2eeDIf2jif7fivItuSfez6TUQh9Xkv1VFr3V8C36pn/8AETcTRSH3Oj/ysIGPUFZeqd2PaDiRbFRT3HC8kBspsUGS9zL7EPP4nzOsf/syX+z/AEo8bPoGNDsh3vWSiSbLYb5WU9+Spdo7RcDYKDnYgRF7J0Tw5ji1zTcFpsQeII0XU+gvTH6TaCewmA7rtBIBr4OGvNcvFyLlZYXFha9hLXsIII4jMH3rrDnljlaOc2JZI0+T6ARQti7QFRBHMP42gkcHaOHk4EeSmrcTTVoxmqdMIiL08CIiAKNtKuZBE+aQ2ZG0uceQF8uJUlcq69dvGOKOkabGTvyfcabMHgXXP4FzOXSrOoR6nRyjpNtqStqZJpDm45Dc1o9lo5AZfHeoLI15hblde4yqMjRxpH5KvyKa2V14mkUZ0iKNo9lkUWWD5lJ2zMHxUbx/QdEfCCQhvwcqJ86zS1N4Ih9SSUeTw135qSMKTRC9R9tSXYy1kgMcThqWBrvGI4L+bQ1bD0VrI6Rj5njItIANruc7U28re/xWnxPPkL2HiblbFsOhMrmyvsWNOV8wCDoBvdplzHELjOtt+D3BK3XfhEGkGWlr+h5bldUkav8ApvsqGM074wGukYcbRYZjDYkDK+ZHOyq6Rvrlr6/7qFztWX8cOlE2BlvJT42qPTt9fJTY2+9QNlhIytZ7uCzMYvxg8z/lZgFGyRBrPX6rIG+PrmvTW/qsoao2e2YwF6ewOBGYuCDa4yIsRkb2sePhbVewFGqq1kRa17rFxs0akngANUV9jySTVM1To30ReyqE0cjXwRFzsIu5xbgcA0jDgLg4gZkXGeWi/erkYnytuC51HVeOcTRrvGR7u7M710PorT/RO0icAO0eZG4v4muzLQeLTlbhZVsVIyGuNQWYIz2kdgfZjlbhcXD75x+BI4LQx5+Or1mXPHTfTxT+D+bKnqgzrzzopv8A5KdZqarULqgkw7QhDsi6CRludmvI/wDbPuUeWTs5HN+q4j3G3yXGb9HHzL2t31k361F/you5n3CgVWzg4X3/ADSnqLqWHXBCgVMrOzLSULXMsoU1NhUygmIyWStZdetJq0eJtM2nqvrP2csB/gcHN+6/IgeBbf8AEt4XKugtT2dcwbpGvYfG2MfFlvNdVWlo5dWKvVsZ2qjWT8wiIrZWCIiAL5u6368y7TnG6PAxvg1gJ/3OcvpFfKfTiXFtCsJ/6mYeTZHNHwCiy8Ilxd2VZfksXa2Xl7lHe5QJE0p0e5ZVGfKvL3LESpYxK8ptnovXsSd232ifgAsCk0sRcQB6zXTpI5Vtkihhu4XBtvt+S3KhqIqNoe5hMhHcBuAeJzGQ4lRR2VLGC7MgX/TxVDVbSdK/HIeQG5o3NCpO8z8PiaUKwKu7L+SvkneZJDdx9wA0DRuAv632lIz1z18/0VJR01Q6HtYobsvYvechbeWjO196lw0Mr/3kz7X9mO0Y8CdSM1xJL1luM2+FZemoZH+8e1t/rEDTO3PyX43bsAOEOc8jcxpPytz13KPQ7Fgb/Kad/eGPM/fvv8FeU7OHu3fooW4kyWTvS9/9iLHtVzs2U0347R33b1JjrKk/8sGnnIx2fkVOjaN2f+dFLhZuXFr1HvS+8n7iFFPUf04fMn5buSy/SKj+nCfN2/yVxBDp6y9WzWf6N68OK9p+pETavl/75GvvrJx/y4f92Rjb/wBxVLtuof2tPKaaYdlJ3rNxtwO1N2Xtaw8lussVuH+FHcxcN0+CRJvu/cWO1a1tRTkNAcXAFjgbYDueLbxy1WsxH9rhleXcDuy3FftVTvjBdBrqYv4X7zhz7jjxBsd4zuPWxoY5W9o12IO3HVp3tOWVjcWsvHLq3ZE8XRwYaahEG0aaobkBKC7haRro3H+15KpOmzOx2hURnfIXDwkAk93eV7tNjm9wnIg4DwNvRv6FN1mzdsKKvGlRTgPA0bLH7YPO77fhVvGuvG4+r5kGScvpFKTvavZwRKapurWnmWn0NTzV/SS6KrKPSybkvIMzdS3qrppM1LMiKRy4n5s15bVwO/1o/cXgH4Ers64vsxpfV04H9aM+QeCfgF2haOg4l+ZQ1vKCIivlIIiIAvlLpxEW7QrAf+pmPk6Rzh8CF9Wr5w66dndjtORw0mZHJ4XHZke+MnzUWVbEuN8mhuKjylZXKO9cRR5JmNxXheyF5IUiIj8UyjfhIPCyiNCyErySvY6i6dkiuqzI5SNmUzSQX3w3zIzIHgodPAXGwGq2bZtD2TDI8gNGnFx3AD1ooMklCNIt4IPJPqkb7sSvjgppGAAxOicBfIue7IZHPNUcPrw9ZeapIq1z7YjpkAMgPAK2pz6/NUHBx5NrHXYtaf14KfH68vl+qgQnX5+vV1Nid63+fD55qMkJ8Q+WXr1kpsJUCL1693NS4X+t11yjmSLimPv/ACUzCMvWW5VlM/jy9eraqcJd+XrRTp7FScXZhnVdFUNklMDO9IAC4AXtfS50BtnZTZnqh6OVAo62pdNYCYgxPPsm4ALS6xwuBGm8KJpN7kqbUW1yTpQQSDkd4K13aGKGcGMfvyRkbATtaXNJ5Pa0tPAgHjfctsTQzHEHBpa03df272Iw21tY+8rTNtNmkYzswHOjmY53ewuIYb9zKxcdNQF4oVLwH0ylHdUyX9KM7Gv4Z8DkcwedwV5qaET7Lqace1SyfSYh/oyEmQc7O7V2X2FkZSlhktm1z3kEbw6zsveVX7M2t9H2jG6QgRW7KW+hglFnF32Q7C4/cUullU67cEc8DyxfRyl1fnX+LOeUc5BstloKjRaUx1uPK+tufNXGzqyynz4rVlbTZbVM3KnnUw1C12mqrqcya6oOLRbNw6Aw9rXMO6Nr3/DAPi8HyXWlwTYu1zTVEcw0a7vAb2HJw9xNudl3mKQOAc03BAII0IOYIWroGuhrvZl61PqTPSIivFM//9k="
        )
        addCelebrity(
            name = "LeBron James",
            image = "data:image/jpeg;base64,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"
        )
    }
    private fun setupRecyclerView() {
        celebritiesAdapter = CelebritiesAdapter(celebrities)
        binding.rvCelebrities.adapter = celebritiesAdapter
    }

    private fun addCelebrity(name: String, image: String) {
        celebrities.add(
            CelebritiesModel(
                name = name,
                image = image
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        celebritiesAdapter = null
    }
}