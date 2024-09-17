import Script from "next/script";
import Link from "next/link";
import './produtos.css';

const Produtos = () => {
    return(
        <>
            <title>Produtos</title>
            <main className="pagina">
                <div className="customer360">
                    <section className="produto1">
                        <article className="artigo1">
                            <h2>Customer 360</h2>
                            <p className="textoartigo">O Customer 360 é uma plataforma integrada de gerenciamento de relacionamento com o cliente (CRM) que fornece uma visão unificada e completa dos clientes.
                            Funciona como uma caixa de ferramentas, que reúne informações de diversas fontes, como e-mails, compras e interações nas redes sociais. </p>
                        </article>
                        <img src="assets/customer1.png" alt="Logo do Customer360" className="customerlogo" />
                    </section>

                    <section className="produto2">
                        <img src="assets/customer2.png" alt="Mulher loira e homem moreno em vídeo chamada" className="customerlogo2"/>
                        <article className="artigo2">
                            <p className="textoartigo">Assim, você pode conhecer seus clientes, compreender seus gostos, o que compram e até mesmo suas necessidades futuras.
                            Isso possibilita oferecer atendimento personalizado e eficaz, com informações organizadas de maneira clara e acessível.</p>
                        </article>
                    </section>
                    <section className="corpobotao">
                        <Link href="/Contato">
                            <button className="textobotao">Entre em contato para saber mais!</button>
                        </Link>
                    </section>
                </div>

                <div className="nuvemdedados">
                    <section className="produto1">
                        <article className="artigo1">
                            <h2>Nuvem de Dados</h2>
                            <p className="textoartigo">O Data Cloud da Salesforce é como um mágico dos dados para negócios. Ele coleta, organiza e analisa informações de várias fontes para te dar insights poderosos sobre os clientes. Imagine que você tem um monte de quebra-cabeças diferentes, cada um representando uma parte da vida do seu cliente – suas compras, preferências, interações online, tudo! </p>
                        </article>
                        <img src="assets/data1.png" alt="Logo da Nuvem de Dados" className="datalogo" />
                    </section>

                    <section className="produto2">
                        <img src="assets/data2.png" alt="" className="datalogo2"/>
                        <article className="artigo2">
                            <p className="textoartigo">O Data Cloud junta essas peças, criando uma imagem completa e clara de cada cliente. Isso ajuda você a entender melhor o que eles querem e como atendê-los de maneira mais eficaz, melhorando suas campanhas de marketing e vendas.</p>
                        </article>
                    </section>

                    <section className="corpobotao">
                        <Link href="/Contato">
                            <button className="textobotao">Entre em contato para saber mais!</button>
                        </Link>
                    </section>
                </div>

                <div className="marketingcloud">
                    <section className="produto1">
                        <article className="artigo1">
                            <h2>Marketing Cloud</h2>
                            <p className="textoartigo">O Marketing Cloud é um como um assistente que ajuda a conhecer melhor os clientes, comunicar-se com eles de forma personalizada. Ele equipa seu negócio com tudo o que é necessário para uma comunicação eficaz e uma estratégia de marketing afiada, contribuindo significativamente para o sucesso e o crescimento da sua empresa.</p>
                        </article>
                        <img src="assets/marketing1.png" alt="" className="marketinglogo" />
                    </section>

                    <section className="produto2">
                        <img src="assets/marketing2.png" alt="Print de um celular mostrando telas do sistema Salesforce" className="marketinglogo2"/>
                        <article className="artigo2">
                            <p className="textoartigo">A ferramenta também é de grande ajuda na gestão de mídias sociais e na criação de anúncios online. E para garantir que você esteja no caminho certo, o Marketing Cloud oferece análises detalhadas sobre o desempenho das suas ações, permitindo ajustes e melhorias contínuas.</p>
                        </article>
                    </section>

                    <section className="corpobotao">
                        <Link href="/Contato">
                            <button className="textobotao">Entre em contato para saber mais!</button>
                        </Link>
                    </section>
                </div>
            </main>
        </>
    )
}

export default Produtos;