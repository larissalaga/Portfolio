import Link from "next/link";
import "../../../public/css/header.css"

const Header = () => {
    return(
        <>
            <header>
                <section className="header">
                    <ul>
                        <li><Link href="/">Home</Link></li>
                        <li><Link href="/reciclagem">Reciclagem</Link> </li>
                    </ul>
                </section>
            </header>
        </>
    )
}

export default Header;