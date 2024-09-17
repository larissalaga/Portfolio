//Larissa Araujo Gama Alvarenga -RM96496
//Larissa Lopes Oliveira -RM552628
//Luna Faustino Lima -RM552473

import Image from "next/image";
import Link from "next/link";
import Carrossel from "./Carrossel/carrossel";


const Home = () => {
    return(
        <>
        <main className="main-home">
            <div className="secao1">
                <section className="bem-vindo">
                    <article className="apresentacao">
                        <h1>
                            Bem vindo à Salesforce!
                        </h1>
                        <h3>
                            <p> A Salesforce é uma plataforma líder em soluções de gerenciamento de relacionamento com o cliente (CRM) e outras ferramentas de negócios baseadas na nuvem. </p>
                            <p>  Pense nela como um assistente multifuncional para negócios, ajudando a gerenciar vendas, atendimento ao cliente, marketing, e mais, tudo em um só lugar.</p>
                        </h3>
                    </article>
                    <Image src="/assets/imagemBemVindo.svg" alt="Imagem Bem Vindo" width="420" height="432" className="imagem-bem-vindo"></Image>
                </section>
                <button className="botao-bem-vindo">
                    <Link href="/Contato" className="link-botao">Clique aqui  para experimentar gratuitamente!</Link>
                </button>
            </div>
            <div className="secao2">
                <h2 className="titulo-sessao">Conheça nossos produtos!</h2>
                <section className="section-cards">
                    <article className="card-produtos">
                        <Image src="/assets/imagemCustomer.svg" alt="Imagem  do Produto Customer 360" width="400" height="225" className="imagem-card"></Image>
                        <h3 className="texto-card">
                        Transforme cada cliente em um amigo! Conheça, entenda e encante como nunca antes!
                        </h3>
                        <button className="botao-card-produtos">
                            <Link href="/Produtos" className="link-card-produtos">Conheça o Customer 360</Link>
                        </button>
                    </article>
                    <article className="card-produtos">
                        <Image src="/assets/imagemNuvemDados.svg" alt="Imagem do Produto Nuvem de Dados" width="400" height="225" className="imagem-card"></Image>
                        <h3 className="texto-card">
                            Descubra os segredos dos seus dados e transforme informações em sucesso!
                        </h3>
                        <button className="botao-card-produtos">
                            <Link href="/Produtos" className="link-card-produtos">Nuvem de dados</Link>                    
                        </button>
                    </article>
                    <article className="card-produtos">
                        <Image src="/assets/imagemMarketing1.svg" alt="Imagem do Produto Explore o Marketing" width="400" height="225" className="imagem-card"></Image>
                        <h3 className="texto-card">
                            Impulsione seu marketing, personalize mensagens  e tenha resultados incríveis!
                        </h3>
                        <button className="botao-card-produtos">
                            <Link href="/Produtos" className="link-card-produtos">Explore o Marketing</Link>
                        </button>
                    </article>
                </section>
                <button className="botao-pag-produtos">
                    <Link href="/Produtos" className="link-pag-produtos">Ver produtos</Link>
                </button>
            </div>
            <div className="secao3">
                <h2 className="titulo-sessao">Depoimentos de Clientes</h2>                
                <section className="section-carrossel">
                    <Carrossel/>
                </section>
            </div>     
        </main>   
        </>
    )
  }
  export default Home;