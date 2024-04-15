import Link from "next/link"
import Image  from "next/image";
import './contato.css';

const Contato = () => {
    return (
        <>
            <div className="total-forms">
                <div className="form-text">
                    <h1 className = "form-titulo">Como podemos ajudar você?</h1>
                    <p className="form-par">
                        Se tiver qualquer dúvida sobre nossos produtos, preços ou como começar a usar, estamos aqui para isso!
                        Nossos especialistas adorariam orientá-lo no caminho certo para o sucesso.
                    </p>
                    <p className = "form-par">
                        Quer conversar? É só preencher o formulário aqui ao lado ou, se preferir, você pode ligar para
                        0800 891 1887!
                    </p>
                    <span className = "form-par">Já é cliente? Visite o link abaixo:</span>
                    <Link className = "form-link" href=".\">Faturamento e Suporte Técnico</Link>
                </div>
                <div className="form-forms">
                    <form >
                        <label className="form-pequeno">
                        <p>Nome</p>
                        <input type="text" name="name"/>
                        </label>
                        <label className="form-pequeno">
                        <p>Email Corporativo</p>
                        <input type="email" name="email"/>
                        </label>
                        <label className="form-pequeno">
                        <p>Telefone</p>
                        <input type="text" name="telefone"/>
                        </label>
                        <label className="form-pequeno">
                        <p>Empresa</p>
                        <input type="text" name="empresa"/>
                        </label>
                        <label className="form-pequeno">
                        <p>Pais/Região</p>
                        <input type="text" name="pais"/>
                        </label>
                        <label className="form-question">
                        <p>Perguntas/Comentários</p>
                        <input type="text" name="perguntas"/>
                        </label>
                        <section className="corpobotao">
                        <Link href="/Contato">
                            <button className="textobotao">RECEBER CONTATO!</button>
                        </Link>
                    </section>
                    </form>

                </div>
            </div>
           
        </>
    )

}
export default Contato;