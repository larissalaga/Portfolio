import Image from "next/image";
import Link from "next/link";
import './footer.css';
const Footer = () => {
    return(
        <>
        <footer>
            <div className="informacoes-footer">
                <section className="section-informacoes">            
                    <h3 className="titulos-footer">Mapa do Site</h3>
                    <nav>                        
                        <ul className="listas-footer">
                            <li><Link href="/" className="itens-lista-footer">Início</Link></li>
                            <li><Link href="/Produtos" className="itens-lista-footer">Produtos</Link></li>
                            <li><Link href="/Contato" className="itens-lista-footer">Contato</Link></li>
                            <li><Link href="/Equipe" className="itens-lista-footer">Equipe</Link></li>
                        </ul>
                    </nav>
                </section>  
                <section className="section-informacoes">
                    <h3 className="titulos-footer">Informações de Contato</h3>
                    <ul className="listas-footer">
                        <li>Endereço: Av. Jornalista Roberto Marinho, 85 – 14º andar – Cidade Monções, São Paulo – SP, 04575-000 Brasil</li>
                        <li>Telefone: 0800 891 1887</li>
                        <li>E-mail: salesforce@salesforce.com</li>
                    </ul>
                </section>   
                <section className="section-informacoes">
                    <h3 className="titulos-footer">Nossas redes sociais</h3>              
                    <nav>
                       
                        <ul className="redes-sociais">
                            <li>
                                <Image src="/assets/iconeFacebook.svg" alt="Ícone Facebook" width="30" height="30"/>
                                <Link href="https://www.facebook.com/SalesforceBrasil/" className="itens-lista-redes">Facebook</Link>
                            </li>
                            <li>
                                <Image src="/assets/iconeInstagram.svg" alt="Ícone Instagram" width="30" height="30"/>
                                <Link href="https://www.instagram.com/salesforcebrasil/" className="itens-lista-redes">Instagram</Link>
                            </li>
                            <li>
                                <Image src="/assets/iconeTwitter.svg" alt="Ícone Twitter" width="30" height="30"/>
                                <Link href="https://twitter.com/salesforce/" className="itens-lista-redes">Twitter</Link>
                            </li>
                            <li>
                                <Image src="/assets/iconeYoutube.svg" alt="Ícone Youtube" width="30" height="30"/>
                                <Link href="https://www.youtube.com/SalesforceBrasil" className="itens-lista-redes">Youtube</Link>
                            </li>
                        </ul>
                    </nav>                
                </section>           
            </div>
            <div>
                <h4 className="direitos-reservados">
                    <p>© 2023 Salesforce, Inc. Todos os direitos reservados.</p> 
                    <p>Salesforce, Inc. Salesforce Tower, 415 Mission Street, 3rd Floor, San Francisco, CA 94105, United States</p>
                </h4>
            </div>
        </footer>        
        </>
    )
}
export default Footer;